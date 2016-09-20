package com.example.shaun.dungeon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

/**
 * Created by shaun on 09/09/2016.
 */
public class CharacterSheet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // TextView Name;
        super.onCreate(savedInstanceState);
        //set which activity is being called i.e the xml file
        setContentView(R.layout.activity_character_sheet);
        Button Edit= (Button) findViewById(R.id.buttonEdit);
        Intent intent = getIntent();
        final String Profile = intent.getStringExtra("filename");

        Edit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ButtonIntent = new Intent(CharacterSheet.this, CharacterCreation.class).putExtra("filename",Profile);
                startActivity(ButtonIntent);

            }
            });

        //Name = (TextView) findViewById(R.id.CharacterNameSheet);
    }
}
