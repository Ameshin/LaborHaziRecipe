package book.laborhazirecipe.android;

import book.laborhazirecipe.interactor.InteractorModule;
import book.laborhazirecipe.model.mock.MockModelModule;
import book.laborhazirecipe.network.mock.MockNetworkModule;
import book.laborhazirecipe.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, MockModelModule.class, MockNetworkModule.class})
public interface MockLaborHaziRecipeApplicationComponent extends LaborHaziRecipeApplicationComponent {

}
