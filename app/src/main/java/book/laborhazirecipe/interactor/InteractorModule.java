package book.laborhazirecipe.interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public RecipeInteractor provideRecipeDbInteractor() {
        return new RecipeInteractor();
    }
}
