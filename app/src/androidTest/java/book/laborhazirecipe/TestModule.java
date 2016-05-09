package book.laborhazirecipe;

import android.content.Context;

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

    //TODO
    @Provides
    public Context provideContext() {
        return viewModule.provideContext();
    }

    @Provides
    public PeopleDbModel provideLoginPresenter() {
        return modelModule.providePeopleDbModel();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return viewModule.provideMainPresenter();
    }
}