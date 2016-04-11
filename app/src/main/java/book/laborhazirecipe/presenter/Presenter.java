package book.laborhazirecipe.presenter;


public class Presenter {
    private static Presenter ourInstance = new Presenter();

    public static Presenter getInstance() {
        return ourInstance;
    }

    private Presenter() {
    }
}
