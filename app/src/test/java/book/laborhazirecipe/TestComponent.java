package book.laborhazirecipe;

import book.laborhazirecipe.android.SugarAppApplicationComponent;
import book.laborhazirecipe.interactor.InteractorModule;
import book.laborhazirecipe.network.mock.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends LaborHaziRecipeApplicationComponent {
}
