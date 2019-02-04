package haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import haitham.kinneret.fastgoodfood.R;

/**
 * Created by Haitham + Fares on 1/31/2018.
 */


public class SearchAdapter extends CursorAdapter {

    private LayoutInflater mInflater;

    public SearchAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.row_search_item,parent,false);
        ViewHolder holder  =   new ViewHolder();

        holder.txtIngredient    =   (TextView)  view.findViewById(R.id.txtIngredient);
        holder.txtRecipe = (TextView) view.findViewById(R.id.txtRecipe);
        holder.txtID = (TextView) view.findViewById(R.id.txtId);
        view.setTag(holder);
        return view;

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder  =   (ViewHolder)    view.getTag();
        holder.txtIngredient.setText(cursor.getString(cursor.getColumnIndex("INGREDIENT")));
        holder.txtRecipe.setText(cursor.getString(cursor.getColumnIndex("RECIPE_NAME")));
        holder.txtID.setText(cursor.getString(cursor.getColumnIndex("_id")));
    }
    static class ViewHolder {
        TextView txtID;
        TextView txtIngredient;
        TextView txtRecipe;
    }
}
