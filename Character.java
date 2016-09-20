package com.example.shaun.dungeon; /**
 * Created by shaun on 29/08/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.shaun.dungeon.R;

import static android.R.interpolator.linear;

public class Character extends  AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set which activity is being called i.e the xml file
            setContentView(R.layout.activity_character);

        //initalize the buttons
        final Button CharacterButton1= (Button) findViewById(R.id.buttonCharacter1);
        final Button CharacterButton2= (Button) findViewById(R.id.buttonCharacter2);
        final Button CharacterButton3= (Button) findViewById(R.id.buttonCharacter3);
        final Button CharacterButton4= (Button) findViewById(R.id.buttonCharacter4);
        final Button CharacterButton5= (Button) findViewById(R.id.buttonCharacter5);
        final Context context=this.getApplicationContext();
        //load the character button names
        String filename1="CharacterProfile1";
        FileIO File= new FileIO();
         String CharacterName1=File.load(filename1,context);
        if(!(CharacterName1.length()==0)) {
            CharacterButton1.setText(CharacterName1);
        }else{
            CharacterButton1.setText(CharacterName1);
        }
        CharacterButton1.setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
             String filename = "CharacterProfile1";
            FileIO File=new FileIO();
            String text =File.load(filename,context);
            if(text.equals("cant read file")){
                //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
                text="New Character";
            }

            if(!text.equals("New Character")) {
                Intent ButtonIntent = new Intent(Character.this, CharacterSheet.class).putExtra("filename",filename);
                startActivity(ButtonIntent);

            }else{
                Intent ButtonIntent = new Intent(Character.this, CharacterCreation.class).putExtra("filename",filename);
                startActivity(ButtonIntent);

            }
        }
    });
         String filename2="CharacterProfile2";
        String CharacterName2 =File.load(filename2,context);
        if(CharacterName2.equals("cant read file")){
            //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
            CharacterName2="New Character";
        }
        CharacterButton2.setText(CharacterName2);
        CharacterButton2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String filename ="CharacterProfile2";
                FileIO File=new FileIO();
                String text =File.load(filename,context);
                if(text.equals("cant read file")){
                    //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
                    text="New Character";
                }
                if(!text.equals("New Character")) {
                    Intent ButtonIntent = new Intent(Character.this, CharacterSheet.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }else{
                    Intent ButtonIntent = new Intent(Character.this, CharacterCreation.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }
            }
        });
         String filename3 ="CharacterProfile3";
      //  FileIO File=new FileIO();
        String CharacterName3 =File.load(filename3,context);
        if(CharacterName3.equals("cant read file")){
            //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
            CharacterName3="New Character";
        }
        CharacterButton3.setText(CharacterName3);
        CharacterButton3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename ="CharacterProfile3";
                FileIO File=new FileIO();
                String text =File.load(filename,context);
                if(text.equals("cant read file")){
                    //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
                    text="New Character";
                }
                if(!text.equals("New Character")) {
                    Intent ButtonIntent = new Intent(Character.this, CharacterSheet.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }else{
                    Intent ButtonIntent = new Intent(Character.this, CharacterCreation.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }
            }
        });
        String filename4 ="CharacterProfile4";
        String CharacterName4 =File.load(filename4,context);
        if(CharacterName4.equals("cant read file")){
            //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
            CharacterName4="New Character";
        }
            CharacterButton4.setText(CharacterName4);
        CharacterButton4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename ="CharacterProfile4";
                FileIO File=new FileIO();
                String text =File.load(filename,context);
                if(text.equals("cant read file")){
                    //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
                    text="New Character";
                }
                if(!text.equals("New Character")) {
                    Intent ButtonIntent = new Intent(Character.this, CharacterSheet.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }else{
                    Intent ButtonIntent = new Intent(Character.this, CharacterCreation.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }
            }
        });
        String filename5 ="CharacterProfile5";
        //  FileIO File=new FileIO();
        String CharacterName5 =File.load(filename5,context);
        System.out.println(CharacterName5);
        if(CharacterName5.equals("cant read file")){
            //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
            CharacterName5="New Character";
        }
        if(!(CharacterName5.length()==0)) {
            CharacterButton5.setText(CharacterName5);
        }else{
            CharacterButton5.setText(CharacterName5);
        }
        CharacterButton5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename ="CharacterProfile5";
                FileIO File=new FileIO();
                String text =File.load(filename,context);
                if(text.equals("cant read file")){
                    //this is to handle unknown exception being thrown by the fileIO class when sending in a file that hasn't been created yet
                    text="New Character";
                }
                if(!text.equals("New Character")) {
                    Intent ButtonIntent = new Intent(Character.this, CharacterSheet.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }else{
                    Intent ButtonIntent = new Intent(Character.this, CharacterCreation.class).putExtra("filename",filename);
                    startActivity(ButtonIntent);
                }
            }
        });
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

