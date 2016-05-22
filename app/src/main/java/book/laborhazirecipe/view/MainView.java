package book.laborhazirecipe.view;

import book.laborhazirecipe.model.Recipe;

import java.util.List;

public interface MainView
{
    void showRecipes(List<Recipe> recipes);

    void showMessage(String msg);
}
