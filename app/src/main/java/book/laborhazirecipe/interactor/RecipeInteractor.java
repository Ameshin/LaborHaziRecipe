package book.laborhazirecipe.interactor;

import book.laborhazirecipe.android.LaborHaziRecipeApplication;
import book.laborhazirecipe.model.prod.RecipeDbModel;
import book.laborhazirecipe.model.Recipe;
import book.laborhazirecipe.network.RecipesApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class RecipeInteractor {
        @Inject
        RecipeDbModel model;

        @Inject
        RecipesApi recipesApi;

        public RecipeInteractor() {
            LaborHaziRecipeApplication.injector.inject(this);
        }

        public void addRecipeToDb(Recipe toAdd) {
            model.insertRecipe(toAdd);
        }

        public List<Recipe> getRecipesFromDb() {
            return model.fetchRecipes();
        }

        public List<Recipe> getRecipesFromNetwork() throws Exception {
            Response<List<Recipe>> response = null;

            Call<List<Recipe>> call = recipesApi.recipesGet();
            try {
                response = call.execute();
            } catch (Exception e) {
                throw new Exception("Network error on execute with get!");
            }
            if (response.code() != 200) {
                throw new Exception("Network error with get!");
            }

            return response.body();
        }
    }
