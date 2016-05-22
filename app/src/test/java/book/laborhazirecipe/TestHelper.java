package book.laborhazirecipe;

import book.laborhazirecipe.android.SugarAppApplication;
import book.laborhazirecipe.android.SugarAppApplicationComponent;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        LaborHaziRecipeApplication application = (LaborHaziRecipeApplication)RuntimeEnvironment.application;
        LaborHaziRecipeApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}
