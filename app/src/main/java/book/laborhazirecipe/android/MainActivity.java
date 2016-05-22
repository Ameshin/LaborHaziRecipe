package book.laborhazirecipe.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import book.laborhazirecipe.BuildConfig;
import book.laborhazirecipe.model.Recipe;
import book.laborhazirecipe.R;
import book.laborhazirecipe.presenter.MainPresenter;
import book.laborhazirecipe.view.MainView;
import com.orm.SugarApp;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LaborHaziRecipeApplication.injector.inject(this);

        SugarContext.init(this);

        // TODO REFRESH BUTTON findViewById(R.id.btnRefresh).setOnClickListener(new View.OnClickListener() {
            // @Override
            // public void onClick(View v) {
                // mainPresenter.refreshRecipes();
            // }
        // });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
        mainPresenter.refreshRecipes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showRecipes(List<Recipe> recipes) {
        final ArrayList<Recipe> list = new ArrayList<>();
        for (int i = 0; i < recipes.size(); ++i) {
            list.add(recipes.get(i));
        }
        //TODO LIST((ListView) findViewById(R.id.listView)).setAdapter( new RecipeAdapter(getApplicationContext(), R.layout.list_item, list));
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
