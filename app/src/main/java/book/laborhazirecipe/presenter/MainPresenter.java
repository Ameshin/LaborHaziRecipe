package book.laborhazirecipe.presenter;

import book.laborhazirecipe.android.LaborHaziRecipeApplication;
import book.laborhazirecipe.interactor.RecipeInteractor;
import book.laborhazirecipe.view.MainView;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainView> {

    @Inject
    public RecipeInteractor interactor;

    public MainPresenter() {
        LaborHaziRecipeApplication.injector.inject(this);
    }

}