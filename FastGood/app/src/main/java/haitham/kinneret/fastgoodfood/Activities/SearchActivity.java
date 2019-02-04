package haitham.kinneret.fastgoodfood.Activities;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters.SearchAdapter;
import haitham.kinneret.fastgoodfood.DatabaseManager.DatabaseAccess;
import haitham.kinneret.fastgoodfood.R;

public class SearchActivity extends AppCompatActivity {

    private SearchAdapter searchAdapter;
    ListView listView;
    Cursor cursor;
    private final static String TAG= MainActivity.class.getName().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        cursor = databaseAccess.getIngredientRecipeList();
        searchAdapter = new SearchAdapter(SearchActivity.this,cursor,0);
        listView = (ListView) findViewById(R.id.lstIngredients);

        listView.setAdapter(searchAdapter);
        databaseAccess.close();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("ListView","You clicked item: " + id + " at position: " + position);

                String text = ((TextView)(view.findViewById(R.id.txtRecipe))).getText().toString();
                Intent intent = new Intent(getApplicationContext(),RecipeDetails.class);
                intent.putExtra("recipeName",text);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                Log.d(TAG, "onQueryTextSubmit ");
                cursor=databaseAccess.getIngredientRecipeByKeyboard(s);
                if (cursor==null){
                    Toast.makeText(SearchActivity.this,"No records found!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SearchActivity.this, cursor.getCount() + " records found!",Toast.LENGTH_LONG).show();
                }
                searchAdapter.swapCursor(cursor);
                databaseAccess.close();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                Log.d(TAG, "onQueryTextChange ");
                cursor=databaseAccess.getIngredientRecipeByKeyboard(s);
                if (cursor!=null){
                    searchAdapter.swapCursor(cursor);
                }
                databaseAccess.close();
                return false;
            }

        });

        return true;
    }
}
