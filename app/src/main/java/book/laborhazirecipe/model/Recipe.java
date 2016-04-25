package book.laborhazirecipe.model;

import android.media.Image;

import com.orm.SugarRecord;

import java.util.List;

public class Recipe extends SugarRecord {
    private String name;
    private String prepTime;
    private int serves;
    private int difficulty;
    private int cost;
    private String preparation;
    private List<String> ingredients;
    private Image image;

    public Recipe(){ }

    public Recipe(String name, String prepTime,int serves, int difficulty, int cost, String preparation, List<String> ingredients, Image image){
        this.setName(name);
        this.setPrepTime(prepTime);
        this.setServes(serves);
        this.setDifficulty(difficulty);
        this.setCost(cost);
        this.setPreparation(preparation);
        this.setIngredients(ingredients);
        this.setImage(image);
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

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getServes() {
        return serves;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }
}
