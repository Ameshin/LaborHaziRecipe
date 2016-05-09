package book.laborhazirecipe.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import book.laborhazirecipe.model.Recipe;
import book.laborhazirecipe.network.GsonHelper;
import book.laborhazirecipe.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2016. 05. 09..
 */
public class RecipeMock {

    static List<Recipe> recipeList = new ArrayList<>();
    static boolean isInitialised = false;

    static ArrayList<String> list1 = new ArrayList<String>() {{
        add("Sajt");
        add("Hús");
        add("Bacon");
    }};
    static ArrayList<String> list2 = new ArrayList<String>() {{
        add("Steak");
        add("Tészta");
        add("Bacon");
    }};
    public static Recipe testR1 = new Recipe("recipe1", "csak ügyesen", list1);
    public static Recipe testR2 = new Recipe("recipe2", "még ügyesebben", list2);

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes") && request.method().equals("GET")) {
            if (!isInitialised) {
                recipeList.add(testR1);
                recipeList.add(testR2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(recipeList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "recipes/1") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(testR1);
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        recipeList.clear();
        isInitialised = false;
    }

}
