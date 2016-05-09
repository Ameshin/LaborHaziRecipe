package book.laborhazirecipe.network;

import book.laborhazirecipe.model.Recipe;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RecipesApi {
  
  /**
   * List of recipes
   * The recipes endpoint returns our current recipe list
   * @param start Starting index of products, default 0.
   * @return Call<List<RecipeBody>>
   */
  
  @GET("recipes")
  Call<List<Recipe>> recipesGet(
    @Query("start") BigDecimal start
  );

  
  /**
   * A single recipe
   * The recipes/{id} endpoint returns a single recipe&#39;s body
   * @param id Unique identifier representing a specific recipe.
   * @return Call<RecipeBody>
   */
  
  @GET("recipes/{id}")
  Call<Recipe> recipesIdGet(
    @Path("id") String id
  );

  
}
