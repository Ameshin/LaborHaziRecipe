package book.laborhazirecipe.android;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import book.laborhazirecipe.R;
import book.laborhazirecipe.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

	private List<Recipe> recipeList;

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public RecipeViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvRecipeName);
        }
    }

    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    public void setList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_row, parent, false);

        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {
        final Recipe recipe = recipeList.get(position);
        holder.name.setText(recipe.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe r = Recipe.findById(Recipe.class, position);
                Intent intent = new Intent(v.getContext(), RecipeDetailsActivity.class);
                intent.putExtra("recipeName", recipe.getName());
                intent.putExtra("recipePreparation", recipe.getPreparation());
                intent.putExtra("recipeImageUrl", recipe.getImageUrl());
                intent.putExtra("recipeIngredients", recipe.getIngredients());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


}
