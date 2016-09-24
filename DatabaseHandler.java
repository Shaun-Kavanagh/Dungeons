package com.example.shaun.dungeon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

/**
 * Created by shaun on 20/09/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="CharacterData";
    private static final int DATABASE_VERSION= 1;
    private static final String Table_Name="ProfileData";

    //have two columns to test
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "Name";
    private static final String KEY_STR ="Strength";
    private static final String KEY_DEX ="Dexterity";
    private static final String KEY_CONST ="Constitution";
    private static final String KEY_INT="Intelligence";
    private static final String KEY_WIS ="Wisdom";

    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE_DATA="CREATE TABLE "+ Table_Name+ "("+ KEY_ID + " INTEGER PRIMARY KEY, "+ KEY_NAME +
                " TEXT, " + KEY_STR+ " INTEGER, "+KEY_DEX+" INTEGER, " +KEY_CONST+ " INTEGER, " +KEY_INT+ " INTEGER, "+ KEY_WIS+ " INTEGER)";
        db.execSQL(CREATE_TABLE_DATA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

        // Create tables again
        onCreate(db);
    }
    public void insert(int id, String name,int Str,int Dex,int Const ,int Int, int Wis){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_NAME, name); // Name
        values.put(KEY_STR, Str); // strength
        values.put(KEY_DEX, Dex); // dexterity
        values.put(KEY_CONST, Const); // Constitution
        values.put(KEY_INT, Int); // Intelligence
        values.put(KEY_WIS, Wis); // Name
        db.insert(Table_Name, null, values);
        db.close();

    }
    public String read(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_ID,KEY_NAME,KEY_STR,KEY_DEX,KEY_CONST,KEY_INT,KEY_WIS}, KEY_ID+ "=?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb= sb.append(cursor.getString(0)+" ");
        sb=sb.append(cursor.getString(1)+" ");
        sb=sb.append(cursor.getString(2)+" ");
        sb=sb.append(cursor.getString(3)+" ");
        sb=sb.append(cursor.getString(4)+" ");
        sb=sb.append(cursor.getString(5)+" ");
        sb=sb.append(cursor.getString(7)+" ");
        String exit= sb.toString();
        return exit;

    }
    public int getStrength(int id){
        int str=0;
        SQLiteDatabase db=this.getReadableDatabase();
        if(db==null){
            return 0;
        }
        //
        // Cursor cursor=db.query(Table_Name,new String[]{"Strength"},"Strength like "+"'" + id+"'", null,null,null,null);
        String[] args={toString().valueOf(id)};
        Cursor cursor=db.rawQuery("SELECT Strength FROM ProfileData WHERE ID  = ?",args);
        while(cursor.moveToFirst()){
            str=cursor.getInt(0);

        }
        cursor.close();

        return str;
    }
    public int test(){
        SQLiteDatabase db= this.getReadableDatabase();

        if(db==null){
            return 100;
        }
        String [] args={"Dylan"};
       // Cursor cursor=db.rawQuery("SELECT Strength FROM ProfileData WHERE Name  = ?",args);
        Cursor cursor=db.query(Table_Name,new String []{KEY_STR},KEY_NAME+"=?",new String[]{"Dylan"},null,null,null,null);
        int ret=17;
        //String]]
        System.out.println("************************************************now");
        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) { // If you use c.moveToNext() here, you will bypass the first row, which is WRONG
                System.out.println("************************************************later");
                ret=Integer.parseInt(cursor.getString(0));
                System.out.println( ret);

                cursor.moveToNext();
            }
        }
      /* if(cursor.moveToFirst()){
           System.out.println("************************************************later");
            ret=Integer.parseInt(cursor.getString(0));
            System.out.println( ret);

       }else{
           ret=72;
       }*/
        cursor.close();
        return ret;

    }
}
