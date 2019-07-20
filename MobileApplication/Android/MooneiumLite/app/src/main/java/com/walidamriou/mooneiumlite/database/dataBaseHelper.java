package com.walidamriou.mooneiumlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dataBaseHelper extends SQLiteOpenHelper{

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "mooneiumlite_data.db";

    public dataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db){
        //create table
        db.execSQL(data.CREATE_TABLE);
    }

    //upgrading database

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS "+ data.TABLE_NAME);

        //Create tables again
        onCreate(db);
    }

    //insertdata

    public long insertData(int id, int password, double money,String currency) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // no need to add them
        values.put(data.COLUMN_ID, id);
        values.put(data.COLUMN_PASSWORD, password);
        values.put(data.COLUMN_MONEY, money);
        values.put(data.COLUMN_CURRENCY, currency);

        // insert row
        db.insert(data.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long updateMONEY(int id, double money) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // no need to add them
        values.put(data.COLUMN_ID, id);
        values.put(data.COLUMN_MONEY, money);

        // insert row
        db.update(data.TABLE_NAME, values,  data.COLUMN_ID + "=" + id, null);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long updatePASSWORD(int id, double password) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // no need to add them
        values.put(data.COLUMN_ID, id);
        values.put(data.COLUMN_PASSWORD, password);

        // insert row
        db.update(data.TABLE_NAME, values,  data.COLUMN_ID + "=" + id, null);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long updateDOURRENCY(int id, String currency) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // no need to add them
        values.put(data.COLUMN_ID, id);
        values.put(data.COLUMN_CURRENCY, currency);

        // insert row
        db.update(data.TABLE_NAME, values,  data.COLUMN_ID + "=" + id, null);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public data getData(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(data.TABLE_NAME,
                new String[]{data.COLUMN_ID, data.COLUMN_PASSWORD, data.COLUMN_MONEY,data.COLUMN_CURRENCY},
                data.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // of the data by the cursor and stare it in datamooneium
        data datamooneium = new data(
                cursor.getInt(cursor.getColumnIndex(data.COLUMN_ID)),
                cursor.getInt(cursor.getColumnIndex(data.COLUMN_PASSWORD)),
                cursor.getDouble(cursor.getColumnIndex(data.COLUMN_MONEY)),
                cursor.getString(cursor.getColumnIndex(data.COLUMN_CURRENCY))
        );

        // close the db connection
        cursor.close();

        return datamooneium;
    }
}

