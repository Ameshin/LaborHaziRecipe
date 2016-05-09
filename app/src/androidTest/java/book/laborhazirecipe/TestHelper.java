package book.laborhazirecipe;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        //TODO
        SugarAppApplication application = (SugarAppApplication)RuntimeEnvironment.application;
        SugarAppApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}