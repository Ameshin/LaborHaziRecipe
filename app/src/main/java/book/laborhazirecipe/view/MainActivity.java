package book.laborhazirecipe.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import book.laborhazirecipe.R;
import book.laborhazirecipe.model.Recipe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.recipe_list);
        //Testing SugarORM entity save and load
        TextView tv = (TextView) findViewById(R.id.main_text);
        //Create ingredients list
        List<String> list = new ArrayList<>();
        list.add("Tojás");
        list.add("Sajt");
        list.add("Kolbász");
        //create recipe with dummy data and the created list
        Recipe recipe = new Recipe("First recipe","Másfél óra", 3, 500, 4, "Dobj bele mindent, és kész is!", list, null);
        recipe.save();
        //testing if recipe was saved successfully
        Recipe recipeLoaded = Recipe.findById(Recipe.class, 1);
        if (tv != null) {
            tv.setText(recipeLoaded.getName());
        }
    }
}