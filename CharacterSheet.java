package com.example.shaun.dungeon;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import org.w3c.dom.Text;

        import java.io.File;

/**
 * Created by shaun on 09/09/2016.
 */
public class CharacterSheet extends AppCompatActivity {
    TextView NameView, Strength,Dexterity,Constitution,Intelligence,Wisdom,Equipment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //set which activity is being called i.e the xml file
        setContentView(R.layout.activity_character_sheet);
        final Context context = this.getApplicationContext();
        Button Edit= (Button) findViewById(R.id.buttonEdit);
        Intent intent = getIntent();
        NameView = (TextView) findViewById(R.id.textViewName);
        Strength = (TextView) findViewById(R.id.textViewStr);
        Dexterity = (TextView) findViewById(R.id.textViewDex);
        Constitution = (TextView) findViewById(R.id.textViewConst);
        Intelligence = (TextView) findViewById(R.id.textViewInt);
        Wisdom = (TextView) findViewById(R.id.textViewWis);
        Equipment=(TextView)findViewById(R.id.textViewEquip);

        final String Profile = intent.getStringExtra("filename");
        int id=1;
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
        DatabaseHandler db= new DatabaseHandler(context);
        try {
            String Name=db.getName(id);
            NameView.setText(Name);
            String str=db.getStrength(id);
            Strength.setText(str);

        }
        catch(RuntimeException e){
            e.printStackTrace();

        }
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
