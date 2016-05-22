package book.laborhazirecipe.presenter;

import javax.inject.Inject;

import book.laborhazirecipe.android.LaborHaziRecipeApplication;
import book.laborhazirecipe.interactor.RecipeInteractor;
import book.laborhazirecipe.view.MainView;

public class RecipeDetailsPresenter extends Presenter<MainView>{
    @Inject
    public RecipeInteractor interactor;

    public RecipeDetailsPresenter() {
        LaborHaziRecipeApplication.injector.inject(this);
    }
}
