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
    EditText NameView, Strength,Dexterity,Constitution,Intelligence,Wisdom;
    TextView NameViewText;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set which activity is being called i.e the xml file
        setContentView(R.layout.activity_character_creation);
        Intent intent = getIntent();
        final String Profile = intent.getStringExtra("filename");
        final int id;
        if(Profile.equals("CharacterProfile1")){
            id=0;
        }else if(Profile.equals("CharacterProfile2")){
            id=1;
        }else if(Profile.equals("CharacterProfile3")){
            id=2;
        }else if(Profile.equals("CharacterProfile4")){
            id=3;
        }else if(Profile.equals("CharacterProfile5")){
            id=4;
        }else{
            id=5;
        }
        NameView = (EditText) findViewById(R.id.CharacterNameCreation);
        Strength=(EditText)findViewById(R.id.editTextStr);
        Dexterity=(EditText)findViewById(R.id.editTextDex);
        Constitution=(EditText)findViewById(R.id.editTextConst);
        Intelligence=(EditText)findViewById(R.id.editTextInt);
        Wisdom=(EditText)findViewById(R.id.editTextWis);
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
                DatabaseHandler db= new DatabaseHandler(context);
                int str= Integer.parseInt(Strength.getText().toString());
                int dex= Integer.parseInt(Dexterity.getText().toString());
                int con= Integer.parseInt(Constitution.getText().toString());
                int inte= Integer.parseInt(Intelligence.getText().toString());
                int wis= Integer.parseInt(Wisdom.getText().toString());

                db.insert(id,Name,str,dex,con,inte,wis);


                //send back to charcter page
                Intent ButtonIntent = new Intent(CharacterCreation.this, Character.class) ;
                startActivity(ButtonIntent);
            }
        });
    }
}