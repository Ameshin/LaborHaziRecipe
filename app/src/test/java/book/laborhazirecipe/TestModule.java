package book.laborhazirecipe;

import android.content.Context;

import book.laborhazirecipe.interactor.InteractorModule;
import book.laborhazirecipe.model.prod.ModelModule;
import book.laborhazirecipe.model.prod.PeopleDbModel;
import book.laborhazirecipe.presenter.MainPresenter;
import book.laborhazirecipe.view.ViewModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    private final ViewModule viewModule;
    private final ModelModule modelModule;

    public TestModule(Context context) {

        this.viewModule = new ViewModule(context);
        this.modelModule = new ModelModule();
    }

    @Provides
    public Context provideContext() {
        return viewModule.provideContext();
    }

    @Provides
    public RecipeDbModel provideLoginPresenter() {
        return modelModule.provideRecipeDbModel();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return viewModule.provideMainPresenter();
    }
}
