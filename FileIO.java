package com.example.shaun.dungeon;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;
import java.util.*;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.*;
/**
 * Created by shaun on 09/09/2016.
 */
public class FileIO {

    public String load(String file, Context context) {

        AssetManager asset = context.getAssets();
        InputStream stream = null;
        String reader = "";
        try {
            stream = asset.open(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cant find file");
        }

       /* InputStreamReader readStream = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(readStream);*/

        try {

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(context.openFileInput(file)));
            String inputString;
            StringBuffer stringBuffer = new StringBuffer();
            while ((inputString = inputReader.readLine()) != null) {
                stringBuffer.append(inputString);

            }


            return stringBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
            String error="cant read file";
             return error;
        }

    }


        public void save(String file,String data, Context context) throws FileNotFoundException, IOException {

            AssetManager asset = context.getAssets();
            InputStream stream = null;
            try {
                stream = asset.open(file);
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("cant find file");
            }

            try { //this writes to the file

                FileOutputStream outputStream = context.openFileOutput(file, Context.MODE_PRIVATE);
                outputStream.write(data.getBytes());
                System.getProperty("line.separator");
                outputStream.flush();
                outputStream.close();
                System.out.println("wrote to file : " + data);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("file not found");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Log.e("Exception", "File write failed: " + e.toString());
                e.printStackTrace();
                System.out.println("random exception");
            }
        }
    }

