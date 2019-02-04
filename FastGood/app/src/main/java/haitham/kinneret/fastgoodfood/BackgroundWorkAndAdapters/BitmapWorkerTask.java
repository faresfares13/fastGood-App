package haitham.kinneret.fastgoodfood.BackgroundWorkAndAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;
/**
 * Created by Haitham + Fares on 1/18/2018.
 */


public class BitmapWorkerTask extends AsyncTask<byte[],Void,Bitmap> {
    private final WeakReference<ImageView> imageViewReference;
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public BitmapWorkerTask(ImageView imageView,Context context) {
        this.context = context;
        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(byte[]... params) {
        byte[] data = params[0];
        return CustomAdapter.decodeSampledBitmapFromResource(context.getResources(), data);

    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
