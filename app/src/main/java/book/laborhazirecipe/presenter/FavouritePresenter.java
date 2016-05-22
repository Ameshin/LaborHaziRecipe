package book.laborhazirecipe.presenter;

import javax.inject.Inject;

import book.laborhazirecipe.LaborHaziRecipeApplication;
import book.laborhazirecipe.interactor.RecipeInteractor;
import book.laborhazirecipe.view.MainView

public class FavouritePresenter extends Presenter<MainView>{
    @Inject
    public RecipeInteractor interactor;

    public DownloadedPresenter() {
        LaborHaziRecipeApplication.injector.inject(this);
    }
}
