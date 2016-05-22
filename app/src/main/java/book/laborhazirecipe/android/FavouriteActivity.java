package book.laborhazirecipe.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import book.laborhazirecipe.R;
import book.laborhazirecipe.model.Recipe;
import book.laborhazirecipe.presenter.FavoruitePresenter;
import book.laborhazirecipe.view.MainView;

public class FavouriteActivity extends AppCompatActivity implements MainView{

	private List<Recipe> recipeList = new ArrayList<>();
    RecipeAdapter recipeAdapter;

    @Inject
    FavouritePresenter favouritePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
		
		SugarContext.init(this);
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
        recipeList = Recipe.listAll(Recipe.class);
        showRecipes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showRecipes()  {
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
