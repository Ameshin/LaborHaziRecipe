package book.laborhazirecipe.android;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import book.laborhazirecipe.BuildConfig;
import book.laborhazirecipe.R;
import book.laborhazirecipe.view.ViewModule;

public class LaborHaziRecipeApplication  extends Application {

    private Tracker mTracker;
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

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
