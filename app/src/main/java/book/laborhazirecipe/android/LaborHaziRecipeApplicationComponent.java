package book.laborhazirecipe.android;

import book.laborhazirecipe.interactor.InteractorModule;
import book.laborhazirecipe.interactor.RecipeInteractor;
import book.laborhazirecipe.model.prod.ModelModule;
import book.laborhazirecipe.network.prod.NetworkModule;
import book.laborhazirecipe.presenter.MainPresenter;
import book.laborhazirecipe.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface LaborHaziRecipeApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(RecipeInteractor interactor);

    void inject(LaborHaziRecipeApplication app);
}

