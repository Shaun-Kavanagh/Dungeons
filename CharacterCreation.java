package com.example.shaun.dungeon;

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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * Created by shaun on 10/09/2016.
 */
public class CharacterCreation extends AppCompatActivity {
    EditText NameView;
    TextView NameViewText;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set which activity is being called i.e the xml file
        setContentView(R.layout.activity_character_creation);
        Intent intent = getIntent();
        final String Profile = intent.getStringExtra("filename");
        NameView = (EditText) findViewById(R.id.CharacterNameCreation);
        final String Name = "Please Enter Character  Name";
        NameView.setText(Name);
        final Button Create = (Button) findViewById(R.id.Create);
        final Context context = this.getApplicationContext();

        Create.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileIO File = new FileIO();
                //File.load(Profile, context);
                String Name = NameView.getText().toString() + "\n";
                try {
                    File.save(Profile, Name, context);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //send back to charcter page
                Intent ButtonIntent = new Intent(CharacterCreation.this, Character.class) ;
                startActivity(ButtonIntent);
            }
        });
    }
}