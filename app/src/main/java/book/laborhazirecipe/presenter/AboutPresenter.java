package book.laborhazirecipe.presenter;

import javax.inject.Inject;

import book.laborhazirecipe.android.LaborHaziRecipeApplication;
import book.laborhazirecipe.interactor.RecipeInteractor;
import book.laborhazirecipe.view.AboutView;

public class AboutPresenter extends Presenter<AboutView> {
    @Inject
    public RecipeInteractor interactor;

    public AboutPresenter() {
        LaborHaziRecipeApplication.injector.inject(this);
    }
}