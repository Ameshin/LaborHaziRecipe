package book.laborhazirecipe;

import javax.inject.Singleton;

import book.laborhazirecipe.network.mock.MockNetworkModule;
import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends SugarAppApplicationComponent {
    //TODO proper extension
}