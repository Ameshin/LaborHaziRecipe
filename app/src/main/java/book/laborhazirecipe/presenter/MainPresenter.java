package book.laborhazirecipe.presenter;

import book.laborhazirecipe.android.SugarAppApplication;
import book.laborhazirecipe.interactor.PeopleInteractor;
import book.laborhazirecipe.model.Person;
import book.laborhazirecipe.view.MainView;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainView> {

    @Inject
    public RecipeInteractor interactor;

    public MainPresenter() {
        LaborHaziRecipeApplication.injector.inject(this);
    }

    public void addRecipe(Recipe toAdd)  {
        try {
            interactor.addRecipeToNetwork(toAdd);
        } catch (Exception e) {
            interactor.addRecipeToDb(toAdd);
            view.showMessage(e.getMessage());
        }

    }

    public void refreshRecipes() {
        try {
            view.showRecipes(interactor.getRecipesFromNetwork());
        } catch (Exception e) {
            view.showRecipes(interactor.getRecipesFromDb());
            view.showMessage(e.getMessage());
        }
    }
}