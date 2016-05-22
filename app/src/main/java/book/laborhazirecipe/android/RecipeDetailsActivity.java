package book.laborhazirecipe.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import book.laborhazirecipe.R;
import book.laborhazirecipe.presenter.RecipeDetailsPresenter;
import book.laborhazirecipe.view.MainView;

public class RecipeDetailsActivity extends AppCompatActivity implements MainView{
	
	private ImageView recipeImage;
    private TextView recipeName;
    private TextView recipePreparation;
    private TextView recipeIngredients;

	@Inject
    RecipeDetailsPresenter detailsPresenter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
		recipeImage = (ImageView)findViewById(R.id.ivDetailRecipeImage);
        recipeName = (TextView)findViewById(R.id.tvDetailRecipeName);
        recipePreparation = (TextView)findViewById(R.id.tvDetailRecipePreparation);
        recipeIngredients = (TextView)findViewById(R.id.tvDetailRecipeIngredients);
    }

	@Override
    protected void onStart() {
        super.onStart();
        showRecipes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showRecipes() {
        Intent intent = getIntent();
        recipeName.setText(intent.getStringExtra("recipeName"));
        recipePreparation.setText(intent.getStringExtra("recipePreparation"));
        recipeIngredients.setText(intent.getStringExtra("recipeIngredients"));
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
