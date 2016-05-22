package book.laborhazirecipe.android;

import android.content.Context;
import android.widget.ArrayAdapter;

import book.laborhazirecipe.model.Recipe;

import java.util.HashMap;
import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    HashMap<Recipe, Integer> mIdMap = new HashMap<Recipe, Integer>();

    public RecipeAdapter(Context context, int textViewResourceId,
                         List<Recipe> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        Recipe item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


}
