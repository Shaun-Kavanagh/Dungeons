package com.example.shaun.dungeon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.*;
import android.provider.Settings;

/**
 * Created by shaun on 20/09/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="CharacterData1";
    private static final int DATABASE_VERSION= 1;
    private static final String Table_Name="ProfileData1";

    //have two columns to test
    private static final String KEY_ID = "ID";
    private static final String KEY_FILE = "FileName";
    private static final String KEY_NAME = "Name";
    private static final String KEY_STR ="Strength";
    private static final String KEY_DEX ="Dexterity";
    private static final String KEY_CONST ="Constitution";
    private static final String KEY_INT="Intelligence";
    private static final String KEY_WIS ="Wisdom";
    private static final String KEY_EQUIP="Equipment";

    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE_DATA="CREATE TABLE "+ Table_Name+ "("+ KEY_ID + " INTEGER PRIMARY KEY, "+KEY_FILE+" TEXT, "+ KEY_NAME +
                " TEXT, " + KEY_STR+ " INTEGER, "+KEY_DEX+" INTEGER, " +KEY_CONST+ " INTEGER, " +KEY_INT+ " INTEGER, "+ KEY_WIS+ " INTEGER, "
                +KEY_EQUIP+" TEXT)";
        db.execSQL(CREATE_TABLE_DATA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

        // Create tables again
        onCreate(db);
    }
    public void insert(int id, String FileName,String name, int Str,int Dex,int Const ,int Int, int Wis,String Equip){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_FILE,FileName);
        values.put(KEY_NAME, name); // Name
        values.put(KEY_STR, Str); // strength
        values.put(KEY_DEX, Dex); // dexterity
        values.put(KEY_CONST, Const); // Constitution
        values.put(KEY_INT, Int); // Intelligence
        values.put(KEY_WIS, Wis); // Name
        values.put(KEY_EQUIP,Equip);
        db.insert(Table_Name, null, values);
        db.close();

    }
    public String read(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_ID,KEY_NAME,KEY_STR,KEY_DEX,KEY_CONST,KEY_INT,KEY_WIS}, KEY_ID+ " = ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        // sb= sb.append(cursor.getString(0)+" ");
        // sb=sb.append(cursor.getString(1)+" ");
        sb=sb.append(cursor.getString(2)+" ");
        //sb=sb.append(cursor.getString(3)+" ");
        //sb=sb.append(cursor.getString(4)+" ");
        //sb=sb.append(cursor.getString(5)+" ");
        //sb=sb.append(cursor.getString(6)+" ");
        String exit= sb.toString();
        return exit;

    }
    public String getStrength(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_STR}, KEY_ID+ " = ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public String getName(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_NAME}, KEY_ID+ " = ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public String getDex(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_DEX}, KEY_ID+ " = ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public String getConst(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_CONST}, KEY_ID+ " = ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public String getInt(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_INT}, KEY_ID+ " = ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public String getWis(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_WIS}, KEY_ID+ "=?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public String getEquip(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_EQUIP}, KEY_ID+ "= ?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb=sb.append(cursor.getString(0)+" ");
        String exit= sb.toString();
        return exit;
    }
    public void update(int id, String FileName,String name, int Str,int Dex,int Const ,int Int, int Wis,String Equip){
        SQLiteDatabase db= this.getReadableDatabase();
        ContentValues values= new ContentValues();

        values.put(KEY_ID,id);
        values.put(KEY_FILE,FileName);
        values.put(KEY_NAME, name); // Name
        values.put(KEY_STR, Str); // strength
        values.put(KEY_DEX, Dex); // dexterity
        values.put(KEY_CONST, Const); // Constitution
        values.put(KEY_INT, Int); // Intelligence
        values.put(KEY_WIS, Wis);
        values.put(KEY_EQUIP,Equip);

        db.update(Table_Name,values,KEY_ID+ " = ?",new String []{String.valueOf(id)});

    }
}