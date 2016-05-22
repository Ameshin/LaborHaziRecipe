package book.laborhazirecipe.unittests;


import book.laborhazirecipe.BuildConfig;
import book.laborhazirecipe.RobolectricDaggerTestRunner;
import book.laborhazirecipe.android.DaggerMockSugarAppApplicationComponent;
import book.laborhazirecipe.android.MockSugarAppApplicationComponent;
import book.laborhazirecipe.android.SugarAppApplication;
import book.laborhazirecipe.interactor.PeopleInteractor;
import book.laborhazirecipe.model.Person;
import book.laborhazirecipe.network.mock.PeopleMock;
import book.laborhazirecipe.view.ViewModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static book.laborhazirecipe.TestHelper.setTestInjector;
import static org.junit.Assert.*;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeUnitTest {

    @Inject
    public RecipeInteractor interactor;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        interactor = new RecipeInteractor();
    }

    @Test
    public void getterTest() throws Exception {
        ArrayList<String> list = new ArrayList<String>() {{
            add("Sajt");
            add("Hús");
            add("Bacon");
        }};
        Recipe testR1 = new Recipe("recipe1", "csak ügyesen", list);

        assertEquals(testR1.getName().equals("recipe1"), true);
    }

    @Test
    public void mockGetTest() throws Exception {
        RecipeMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<Recipe> r = interactor.getRecipesFromNetwork();
            assertEquals(r.get(0).getName(), RecipeMock.testR1.getName());
            assertEquals(r.get(1).getName(), RecipeMock.testR2.getName());
        }
    }

    @Test
    public void mockAddTest() throws Exception {
        RecipeMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            ArrayList<String> list = new ArrayList<String>() {{
				add("Sajt");
				add("Hús");
				add("Bacon");
			}};
			Recipe n = new Recipe("recipe1", "csak ügyesen", list);
            interactor.addRecipeToNetwork(n);
            List<Recipe> r = interactor.getRecipesFromNetwork();
            assertEquals(r.get(1).getName(), RecipeMock.testR1.getName());
            assertEquals(r.get(2).getName(), RecipeMock.testR2.getName());
            assertEquals(r.get(0).getName(), n.getName());
        }
    }
}
