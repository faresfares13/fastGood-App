package haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import haitham.kinneret.fastgoodfood.R;
import haitham.kinneret.fastgoodfood.Activities.RecipeDetails;

/**
 * Created by Haitham + Fares on 1/26/2018.
 */

public class CustomAdapter  extends BaseAdapter {
    private String [] resultNames;
    private Context context;
    private int [] imageId;
    private ArrayList<byte[]> list;
    private byte[] image;


    private static LayoutInflater inflater = null;
    public CustomAdapter(Context choosenContext, String[] recipeNameList, ArrayList<byte[]> images) {
        resultNames=recipeNameList;
        context = choosenContext;
        list = images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return resultNames.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView recipe_text;
        ImageView recipe_img;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) throws OutOfMemoryError {
        Holder holder=new Holder();
        View rowView;

            rowView = inflater.inflate(R.layout.gridview_layout_tabs, null);
            holder.recipe_text = (TextView) rowView.findViewById(R.id.recipe_texts);
            holder.recipe_img = (ImageView) rowView.findViewById(R.id.recipe_images);



            Food food = new Food(resultNames[position],list.get(position),resultNames[position],resultNames[position]);

            holder.recipe_text.setText(food.getRecipe());
            loadBitmap(food.getImage(),holder.recipe_img);

            rowView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, RecipeDetails.class);
                    i.putExtra("recipeName",resultNames[position]);
                    context.startActivity(i);
                    Toast.makeText(context, "You Clicked " + resultNames[position], Toast.LENGTH_SHORT).show();
                }
            });

        return rowView;
    }
    private void loadBitmap(byte[] resId, ImageView imageView) {
        BitmapWorkerTask task = new BitmapWorkerTask(imageView,context);
        task.execute(resId);
    }


    private static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, byte[] resId) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(resId, 0, resId.length,options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 450, 270);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(resId, 0, resId.length,options);
    }


}