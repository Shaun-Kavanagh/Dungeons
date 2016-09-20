package com.example.shaun.dungeon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shaun on 20/09/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="TestData";
    private static final int DATABASE_VERSION= 1;
    private static final String Table_Name="TableData";

    //have two columns to test
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";


    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE_DATA="CREATE TABLE "+ Table_Name+ "("+ KEY_ID + " INTEGER PRIMARY KEY, "+ KEY_NAME +
                " TEXT)";
        db.execSQL(CREATE_TABLE_DATA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

        // Create tables again
        onCreate(db);
    }
    public void insert(String data, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int id_parse=Integer.parseInt(id);
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, data); // Name
        values.put(KEY_ID,id_parse);

        db.insert(Table_Name, null, values);
        db.close();

    }
    public String read(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(Table_Name, new String []{KEY_ID,KEY_NAME}, KEY_ID+ "=?", new String []{String.valueOf(id)},
                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        StringBuffer sb= new StringBuffer();
        sb= sb.append(cursor.getString(0));
        sb=sb.append(cursor.getString(1));
        String exit= sb.toString();
        return exit;

    }
}
