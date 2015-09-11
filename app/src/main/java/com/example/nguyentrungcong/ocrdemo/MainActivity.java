package com.example.nguyentrungcong.ocrdemo;

import android.graphics.BitmapFactory;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nguyentrungcong.createfilefromassets.CreateFileFromAssets;
import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream inputStream = null;
        OutputStream outputStream = null;

//        try {
            // read this file into InputStream
//            inputStream = getAssets().open("tessdata/eng.traineddata");

            // write the inputStream to a FileOutputStream
            File dir = new File(getFilesDir().getPath()+"/tessdata");
            if(!dir.exists()){
                dir.mkdir();
            }
            CreateFileFromAssets.getInstance().initialize(MainActivity.this).CreateFileFromPath("tessdata");
           /* File file = new File(getFilesDir().getPath()+"/tessdata/eng.traineddata");
            if (!file.exists()){
                file.createNewFile();
            }
            outputStream =
                    new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }*/
        File f = new File(getFilesDir().getPath()+"/tessdata/eng.traineddata");
        if (f.exists()){
            Toast.makeText(MainActivity.this, "Exists "+getFilesDir().getPath()+"/tessdata/eng.traineddata", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(MainActivity.this, "Not Exist "+getFilesDir().getPath()+"/tessdata/eng.traineddata", Toast.LENGTH_SHORT).show();
        }
        Log.d("TAg,", getFilesDir().getPath()+"/tessdata/eng.traineddata");
        TessBaseAPI baseApi = new TessBaseAPI();
        baseApi.init(getFilesDir().getPath(), "eng");
        baseApi.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.write));
        String recognizedText = baseApi.getUTF8Text();
        baseApi.end();
        Toast.makeText(MainActivity.this, "" + recognizedText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
