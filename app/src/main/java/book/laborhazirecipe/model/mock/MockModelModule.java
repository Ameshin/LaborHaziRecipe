package book.laborhazirecipe.model.mock;

import book.laborhazirecipe.model.prod.RecipeDbModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MockModelModule {

    @Provides
    public RecipeDbModel provideMockRecipeDbModel() {
        return new MockRecipeDbModel();
    }
}
