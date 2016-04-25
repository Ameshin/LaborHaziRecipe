package book.laborhazirecipe.presenter;

public class AboutPresenter {
    private static AboutPresenter ourInstance = new AboutPresenter();

    public static AboutPresenter getInstance() {
        return ourInstance;
    }

    private AboutPresenter() {
    }
}
