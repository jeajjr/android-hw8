package com.almasapp.hw8.almasapp8;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * Created by José Ernesto on 25/03/2015.
 */
public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> imageViewWeakReference;

    public ImageDownloader(ImageView imageView) {
        imageViewWeakReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        Bitmap bitmap = null;

        bitmap = HTTPClient.getMovieImage(url);

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            final ImageView imageView = imageViewWeakReference.get();

            if (imageView != null)
                imageView.setImageBitmap(bitmap);
        }
    }
}
