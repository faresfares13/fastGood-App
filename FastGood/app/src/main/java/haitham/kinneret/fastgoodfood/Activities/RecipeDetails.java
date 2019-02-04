package haitham.kinneret.fastgoodfood.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters.CustomAdapter;
import haitham.kinneret.fastgoodfood.DatabaseManager.DatabaseAccess;
import haitham.kinneret.fastgoodfood.R;

public class RecipeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        // get data via the key
        final String recipeName = extras.getString("recipeName");
        TextView steps = (TextView) findViewById(R.id.steps);
        TextView ingredients = (TextView) findViewById(R.id.ingredientList);
        ImageView imageView = (ImageView) findViewById(R.id.recipeImage);
        TextView chosenRecipeName = (TextView) findViewById(R.id.recipeText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addIngredients);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                makeADecision(databaseAccess.getIngredients(recipeName));
                databaseAccess.close();
            }
        });


        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        // the chosen recipes' image
        Bitmap bitmap = CustomAdapter.decodeSampledBitmapFromResource(this.getResources(), databaseAccess.getImage(recipeName));
        imageView.setImageBitmap(bitmap);
        // the recipe name
        chosenRecipeName.setText(recipeName);
        // list of ingredients
        ingredients.setText(stringArrayToString(databaseAccess.getIngredients(recipeName)));
        //steps
        steps.setText(databaseAccess.getSteps(recipeName));

        databaseAccess.close();
    }

    private String stringArrayToString(String[] array){
        String output = "";
        for(String item:array)

            output +=  item + "\n";
        return output;
    }

    public void makeADecision(final String[] array){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Send ingredients to shopping list");
        alertDialog.setMessage("Click 'Send & Display' to send and open shopping list" +
                " or 'Discard' to cancel.");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Send & Display", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //TODO

               Intent intent = new Intent(getApplicationContext(),ShoppingListActivity.class);
               intent.putExtra("Ingredients",array);
               startActivity(intent);

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Discard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }
}
