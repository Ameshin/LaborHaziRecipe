package book.laborhazirecipe.model.mock;

import book.laborhazirecipe.model.prod.RecipeDbModel;
import book.laborhazirecipe.model.Recipe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MockRecipeDbModel extends RecipeDbModel {

    LinkedList<Recipe> values = new LinkedList<>();

    public MockRecipeDbModel() {
		ArrayList<String> list = new ArrayList<String>() {{
            add("Sajt");
            add("Hús");
            add("Bacon");
        }};
        Recipe testR1 = new Recipe("recipe1", "csak ügyesen", list);
		Recipe testR2 = new Recipe("recipe2", "csak ügyesen", list);
        values.add(testR1);
        values.add(testR2);
    }

    @Override
    public List<Recipe> fetchRecipes() {
        return values;
    }

    @Override
    public void insertRecipe(Recipe toInsert) {
        values.add(toInsert);
    }
}
