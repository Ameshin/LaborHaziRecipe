package book.laborhazirecipe.model.prod;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    public RecipeDbModel provideRecipeDbModel() {
        return new RecipeDbModel();
    }
}
