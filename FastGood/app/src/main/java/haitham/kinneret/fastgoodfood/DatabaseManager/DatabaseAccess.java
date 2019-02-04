package haitham.kinneret.fastgoodfood.DatabaseManager;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;



import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Haitham + Fares on 1/23/2018.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    //region Constructors
    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    //endregion

    //region DB open/close
    /**
     * Open the database connection.
     */
    public void open() {

        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    //endregion

    //region DBAccessForTABs
    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public String[] getRecipeName() {
        Cursor cursor = database.rawQuery("SELECT RECIPE_NAME FROM RECIPES " +
                "ORDER BY RECIPE_NAME ;", null);
        String[] names = new String[cursor.getCount()];
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(0);
            names[i] = name;
            cursor.moveToNext();
            i++;

        }
        cursor.close();
        return names;
    }


    public ArrayList<byte[]> getImages(){

        ArrayList<byte[]> imageList = new ArrayList<byte[]>();
        Cursor cursor = database.rawQuery("SELECT IMAGE FROM RECIPES" +
                " ORDER BY RECIPE_NAME ;",null);
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()){
            byte[] data = cursor.getBlob(0);
            imageList.add(data);
            //imageList.add(cursor.getBlob(0));
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return imageList;
    }

    public String[] getVegetarianRecipeName() {
        Cursor cursor = database.rawQuery("SELECT RECIPE_NAME FROM RECIPES " +
                "WHERE COOKING_STYLE = 'vegetarin' " +
                "ORDER BY RECIPE_NAME ;", null);
        String[] names = new String[cursor.getCount()];
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(0);
            names[i] = name;
            cursor.moveToNext();
            i++;

        }
        cursor.close();
        return names;
    }

    public ArrayList<byte[]> getVegetarianImages(){

        ArrayList<byte[]> imageList = new ArrayList<byte[]>();
        Cursor cursor = database.rawQuery("SELECT IMAGE FROM RECIPES" +
                " WHERE COOKING_STYLE = 'vegetarin' " +
                " ORDER BY RECIPE_NAME ;",null);
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()){
            byte[] data = cursor.getBlob(0);
            imageList.add(data);
            //imageList.add(cursor.getBlob(0));
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return imageList;
    }

    public String[] getVeganRecipeName() {
        Cursor cursor = database.rawQuery("SELECT RECIPE_NAME FROM RECIPES " +
                "WHERE COOKING_STYLE = 'vegan' " +
                "ORDER BY RECIPE_NAME ;", null);
        String[] names = new String[cursor.getCount()];
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(0);
            names[i] = name;
            cursor.moveToNext();
            i++;

        }
        cursor.close();
        return names;
    }

    public ArrayList<byte[]> getVeganImages(){

        ArrayList<byte[]> imageList = new ArrayList<byte[]>();
        Cursor cursor = database.rawQuery("SELECT IMAGE FROM RECIPES" +
                " WHERE COOKING_STYLE = 'vegan' " +
                " ORDER BY RECIPE_NAME ;",null);
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()){
            byte[] data = cursor.getBlob(0);
            imageList.add(data);
            //imageList.add(cursor.getBlob(0));
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return imageList;
    }
    public String[] getQERecipeName() {
        Cursor cursor = database.rawQuery("SELECT RECIPE_NAME FROM RECIPES " +
                "WHERE COOKING_STYLE = 'QE' " +
                "ORDER BY RECIPE_NAME ;", null);
        String[] names = new String[cursor.getCount()];
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(0);
            names[i] = name;
            cursor.moveToNext();
            i++;

        }
        cursor.close();
        return names;
    }

    public ArrayList<byte[]> getQEImages(){

        ArrayList<byte[]> imageList = new ArrayList<byte[]>();
        Cursor cursor = database.rawQuery("SELECT IMAGE FROM RECIPES" +
                " WHERE COOKING_STYLE = 'QE' " +
                " ORDER BY RECIPE_NAME ;",null);
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()){
            byte[] data = cursor.getBlob(0);
            imageList.add(data);
            //imageList.add(cursor.getBlob(0));
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return imageList;
    }

    public String[] getSCRecipeName() {
        Cursor cursor = database.rawQuery("SELECT RECIPE_NAME FROM RECIPES " +
                "WHERE COOKING_STYLE = 'SC' " +
                "ORDER BY RECIPE_NAME ;", null);
        String[] names = new String[cursor.getCount()];
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(0);
            names[i] = name;
            cursor.moveToNext();
            i++;

        }
        cursor.close();
        return names;
    }

    public ArrayList<byte[]> getSCImages(){

        ArrayList<byte[]> imageList = new ArrayList<byte[]>();
        Cursor cursor = database.rawQuery("SELECT IMAGE FROM RECIPES" +
                " WHERE COOKING_STYLE = 'SC' " +
                " ORDER BY RECIPE_NAME ;",null);
        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()){
            byte[] data = cursor.getBlob(0);
            imageList.add(data);
            //imageList.add(cursor.getBlob(0));
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return imageList;
    }
//endregion

    //region RecipeDetails
    public String getSteps(String recipeName){
        String steps = "";
        String s = String.format("SELECT STEPS FROM RECIPES" +
                " WHERE RECIPE_NAME = '%s';",recipeName);

        Cursor cursor = database.rawQuery(s,null);
        cursor.moveToFirst();
        steps = cursor.getString(0);
        cursor.close();
        return steps;
    }

    public String[] getIngredients(String recipeName){

        String ingeredient = String.format("SELECT AMOUNT || ' - ' || INGREDIENT FROM RECIPE_CONTENT" +
                " WHERE RECIPE_NAME = '%s' ORDER BY AMOUNT;",recipeName);
        Cursor cursorIngredient = database.rawQuery(ingeredient,null);
        String[] ingredients = new String[cursorIngredient.getCount()];

        cursorIngredient.moveToFirst();
        int i = 0;
        while (!cursorIngredient.isAfterLast()) {
            String ingredientName =cursorIngredient.getString(0);
            ingredients[i] = ingredientName;
            cursorIngredient.moveToNext();
            i++;

        }
        cursorIngredient.close();
        return ingredients;
    }

  public byte[] getImage(String recipeName){
      byte[] imageArray ={};
      String s = String.format("SELECT IMAGE FROM RECIPES" +
              " WHERE RECIPE_NAME = '%s';",recipeName);
      Cursor cursor = database.rawQuery(s,null);
      cursor.moveToFirst();
      int i = 0;
      while (!cursor.isAfterLast()){
          imageArray = cursor.getBlob(0);
          cursor.moveToNext();
          i++;
      }
      cursor.close();
      return imageArray;
  }
    //endregion

    //region DBAccessForSearch

    public Cursor getIngredientRecipeList(){
      String selectQuery = "SELECT ROWID AS _id ,INGREDIENT , RECIPE_NAME \n" +
              "FROM RECIPE_CONTENT ;";
      Cursor cursor = database.rawQuery(selectQuery,null);
        // looping through all rows and adding to list

        if(cursor==null){
            return null;
        }else if(!cursor.moveToFirst()){
            cursor.close();
            return null;
        }
        return cursor;
    }

    public Cursor getIngredientRecipeByKeyboard(String search){


        String selectQuery = "SELECT ROWID AS _id ,INGREDIENT , RECIPE_NAME " +
                              " FROM RECIPE_CONTENT"  +
                              " WHERE INGREDIENT LIKE '"+search+"%'" +
                              " OR RECIPE_NAME LIKE '"+search+"%';";
        Cursor cursor = database.rawQuery(selectQuery,null);
        if(cursor==null){
            return null;
        }else if(!cursor.moveToFirst()){
            cursor.close();
            return null;
        }
        return cursor;
    }
    //endregion

}