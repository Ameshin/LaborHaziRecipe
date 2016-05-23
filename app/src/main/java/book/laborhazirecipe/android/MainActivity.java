package book.laborhazirecipe.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.orm.SugarContext;

import book.laborhazirecipe.BuildConfig;
import book.laborhazirecipe.model.Recipe;
import book.laborhazirecipe.R;
import book.laborhazirecipe.presenter.MainPresenter;
import book.laborhazirecipe.view.MainView;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

	private List<Recipe> recipeList = new ArrayList<>();

    @Inject
    MainPresenter mainPresenter;

	RecipeAdapter recipeAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

		SugarContext.init(this);
		
        LaborHaziRecipeApplication.injector.inject(this);
		Recipe.findById(Recipe.class, (long) 1);
        Recipe.listAll(Recipe.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvRecipes);

        recipeAdapter = new RecipeAdapter(recipeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recipeAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
		recipeList = Recipe.listAll(Recipe.class);
        showRecipes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showRecipes() {
        recipeAdapter.setList(recipeList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_nav, menu);
        return true;
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.onlineSearch:
                Intent intentOnlineSearch = new Intent(this, MainActivity.class);
                this.startActivity(intentOnlineSearch);
                break;
            case R.id.offlineLookup:
                Intent intentOfflineLookup = new Intent(this, FavouriteActivity.class);
                this.startActivity(intentOfflineLookup);
                break;
            case R.id.about:
                Intent intentAbout = new Intent(this, AboutActivity.class);
                this.startActivity(intentAbout);
                break;
        }
        return true;
    }
}
