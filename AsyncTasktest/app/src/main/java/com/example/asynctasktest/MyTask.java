package com.example.asynctasktest;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<String,Void, Bitmap> {

    String imgurl = "https://img.etimg.com/thumb/width-640,height-480,imgsize-615967,resizemode-1,msid-70797549/no-more-desserts-google-breaks-10-year-old-tradition-officially-names-latest-os-android-10.jpg";

    ProgressDialog pd;

    Context ct;
    ImageView myIv;
    public MyTask(MainActivity mainActivity, ImageView iv) {
        ct = mainActivity;
        myIv = iv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ct);
        pd.setMessage("Please wait.....");
        pd.setCancelable(false);
        pd.show();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL u = new URL(imgurl);
            HttpsURLConnection connection =(HttpsURLConnection)
                    u.openConnection();
            InputStream is = connection.getInputStream();
            Bitmap b = BitmapFactory.decodeStream(is);
            return  b;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        myIv.setImageBitmap(bitmap);
        pd.dismiss();

    }
}
