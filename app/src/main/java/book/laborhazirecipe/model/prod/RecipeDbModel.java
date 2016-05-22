package book.laborhazirecipe.model.prod;

import book.laborhazirecipe.model.Recipe;

import java.util.LinkedList;
import java.util.List;

public class RecipeDbModel {

    public RecipeDbModel() {

    }

    public List<Recipe> fetchRecipes() {
        List<Recipe> values = Recipe.listAll(Recipe.class);
        return values;
    }

    public void insertRecipe(Recipe toInsert) {
        toInsert.save();
    }
}


