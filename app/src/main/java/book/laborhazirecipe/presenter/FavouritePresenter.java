package book.laborhazirecipe.presenter;

public class FavouritePresenter {
    private static FavouritePresenter ourInstance = new FavouritePresenter();

    public static FavouritePresenter getInstance() {
        return ourInstance;
    }

    private FavouritePresenter() {
    }
}
