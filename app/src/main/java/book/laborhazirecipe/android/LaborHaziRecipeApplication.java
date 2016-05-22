package book.laborhazirecipe.android;

import android.app.Application;

import book.laborhazirecipe.BuildConfig;
import book.laborhazirecipe.view.ViewModule;

public class LaborHaziRecipeApplication  extends Application {

    public static LaborHaziRecipeApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.FLAVOR.equals("mock")) {
            injector = DaggerMockLaborHaziRecipeApplicationComponent.builder().viewModule(new ViewModule(this)).build();
        } else {
            injector = DaggerLaborHaziRecipeApplicationComponent.builder().viewModule(new ViewModule(this)).build();
        }
    }

    public void setInjector(LaborHaziRecipeApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
    }
}
