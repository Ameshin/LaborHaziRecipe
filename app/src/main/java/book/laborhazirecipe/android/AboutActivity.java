package book.laborhazirecipe.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import book.laborhazirecipe.presenter.AboutPresenter;
import book.laborhazirecipe.view.AboutView;
import book.laborhazirecipe.R;

public class AboutActivity extends AppCompatActivity implements AboutView {

    Tracker mTracker;

	@Inject
    AboutPresenter aboutPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        LaborHaziRecipeApplication app = (LaborHaziRecipeApplication) getApplication();
        mTracker = app.getDefaultTracker();
        Log.i("Analytics", "AboutActivity");
        mTracker.setScreenName("AboutActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

	@Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showAbout() {

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
