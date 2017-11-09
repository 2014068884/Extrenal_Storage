package com.sebanes.extrenal_storage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText eMessage;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eMessage = (EditText) findViewById(R.id.edMessage);
    }

    public void saveInternalCache(View view) {
        File folder = getCacheDir();
        File file = new File(folder, "data1.txt");
        String message = eMessage.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to internal cache", Toast.LENGTH_LONG).show();
    }

    public void saveExternalCache(View view) {
        File folder = getExternalCacheDir();
        File file = new File(folder, "data2.txt");
        String message = eMessage.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to external cache", Toast.LENGTH_LONG).show();
    }

    public void saveExternalStorage(View view) {
        File folder = getExternalFilesDir("temp");
        File file = new File(folder, "data3.txt");
        String message = eMessage.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to external storage", Toast.LENGTH_LONG).show();
    }

    public void saveExternalPubStor(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "data4.txt");
        String message = eMessage.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to external storage", Toast.LENGTH_LONG).show();
    }

    public void next(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            FileInputStream fis = openFileInput("output.txt");
            while((read = fis.read()) != -1) {
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvMessage.setText(buffer.toString());
    }
}
