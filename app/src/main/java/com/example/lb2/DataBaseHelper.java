package com.example.lb2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CUSTOMER(ID LONG PRIMARY KEY, NAME TEXT, PHONE TEXT, GENDER TEXT , ADDRESS TEXT)");
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       
    }


    public void insertCustomer(Customer customer) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", customer.getmCustomerId());
        contentValues.put("NAME", customer.getmName());
        contentValues.put("PHONE", customer.getmPhone());
        contentValues.put("GENDER", customer.getmGender());
        contentValues.put("ADDRESS", customer.getMaddress());
        sqLiteDatabase.insert("CUSTOMER", null, contentValues); }

    public Cursor getAllCustomers() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM CUSTOMER", null);
    }
}
