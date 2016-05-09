package book.laborhazirecipe;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

import book.laborhazirecipe.model.Recipe;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        ArrayList<String> list = new ArrayList<String>() {{
            add("Sajt");
            add("Hús");
            add("Bacon");
        }};
        Recipe testR1 = new Recipe("recipe1", "csak ügyesen", list);

        assertEquals(testR1.getName().equals("recipe1"), true);
    }
}