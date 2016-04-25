package book.laborhazirecipe.presenter;

public class RecipeDetailsPresenter {
    private static RecipeDetailsPresenter ourInstance = new RecipeDetailsPresenter();

    public static RecipeDetailsPresenter getInstance() {
        return ourInstance;
    }

    private RecipeDetailsPresenter() {
    }
}
