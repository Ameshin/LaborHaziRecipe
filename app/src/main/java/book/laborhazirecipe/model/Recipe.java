package book.laborhazirecipe.model;

import android.media.Image;

import com.orm.SugarRecord;

import java.util.List;
import java.util.Objects;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Recipe extends SugarRecord {

    @SerializedName("id")
    private BigDecimal recipeId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("prepTime")
    private String prepTime = null;

    @SerializedName("serves")
    private int serves = 0;

    @SerializedName("difficulty")
    private int difficulty = 0;

    @SerializedName("cost")
    private BigDecimal cost = null;

    @SerializedName("preparation")
    private String preparation = null;

    @SerializedName("ingredients")
    private List<String> ingredients = new ArrayList<String>();

    @SerializedName("image")
    private Image image = null;

    @SerializedName("imageUrl")
    private String imageUrl = null;

    public Recipe(){ }

    public Recipe(String name, String preparation, List<String> ingredients){
        this.setName(name);
        this.setPreparation(preparation);
        this.setIngredients(ingredients);
    }

    public Recipe(BigDecimal recipeId, String name, String prepTime,int serves, int difficulty, BigDecimal cost, String preparation, List<String> ingredients, Image image, String imageUrl){
        this.setRecipeId(recipeId);
        this.setName(name);
        this.setPrepTime(prepTime);
        this.setServes(serves);
        this.setDifficulty(difficulty);
        this.setCost(cost);
        this.setPreparation(preparation);
        this.setIngredients(ingredients);
        this.setImage(image);
        this.setImageUrl(imageUrl);
    }

    /**
     * Unique identifier representing a specific recipe.
     **/
    public BigDecimal getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(BigDecimal id) {
        this.recipeId = id;
    }

    public void addIngredient(String ingredient){
        this.getIngredients().add(ingredient);
    }

    public void removeIngredient(String ingredient){
        this.getIngredients().remove(ingredient);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Time required to prepare meal
     **/
    public String getPrepTime() {
        return prepTime;
    }
    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    /**
     * How many people it serves
     **/
    public int getServes() {
        return serves;
    }
    public void setServes(int serves) {
        this.serves = serves;
    }

    /**
     * Difficulty of preparing the meal
     **/
    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Cost of a recipe for given people
     **/
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * Guide to prepare the meal described in the recipe.
     **/
    public String getPreparation() {
        return preparation;
    }
    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    /**
     * List of string to get required ingredients for the recipe
     **/
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * image URL for meal image
     **/
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String image) {
        this.imageUrl = image;
    }

    /**
     * image for meal
     **/
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipe recipeBody = (Recipe) o;
        return Objects.equals(recipeId, recipeBody.recipeId) &&
                Objects.equals(name, recipeBody.name) &&
                Objects.equals(prepTime, recipeBody.prepTime) &&
                Objects.equals(serves, recipeBody.serves) &&
                Objects.equals(difficulty, recipeBody.difficulty) &&
                Objects.equals(cost, recipeBody.cost) &&
                Objects.equals(preparation, recipeBody.preparation) &&
                Objects.equals(ingredients, recipeBody.ingredients) &&
                Objects.equals(image, recipeBody.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, name, prepTime, serves, difficulty, cost, preparation, ingredients, image);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecipeBody {\n");

        sb.append("    recipeId: ").append(toIndentedString(recipeId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    prepTime: ").append(toIndentedString(prepTime)).append("\n");
        sb.append("    serves: ").append(toIndentedString(serves)).append("\n");
        sb.append("    difficulty: ").append(toIndentedString(difficulty)).append("\n");
        sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
        sb.append("    preparation: ").append(toIndentedString(preparation)).append("\n");
        sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
