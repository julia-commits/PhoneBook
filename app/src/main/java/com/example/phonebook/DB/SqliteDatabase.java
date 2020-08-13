package com.example.phonebook.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SqliteDatabase extends SQLiteOpenHelper {
    private	static final int DATABASE_VERSION =	5;
    private	static final String	DATABASE_NAME = "phonebook";
    private	static final String TABLE_CONTACTS = "contacts";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_F_NAME = "f_name";
    private static final String COLUMN_L_NAME = "l_name";
    private static final String COLUMN_PHONE = "phone_number";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_PROFILE_PICTURE = "profile_picture";





    public SqliteDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String	CREATE_CONTACTS_TABLE = "CREATE	TABLE " + TABLE_CONTACTS +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_F_NAME + " STRING," + COLUMN_PHONE + " STRING," +
                COLUMN_L_NAME + "STRING," + COLUMN_EMAIL + "STRING," + COLUMN_ADDRESS + "STRING," + COLUMN_GENDER + "STRING," +
                COLUMN_DOB + "DATE," + COLUMN_PROFILE_PICTURE + "BLOB" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_CONTACTS + "'");
        onCreate(db);
    }

    public ArrayList <Contact> listContacts () {
        String sql = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList <Contact> storeContacts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String f_name =cursor.getString(1);
                String l_name = cursor.getString(2);
                String email = cursor.getString(3);
                String phone = cursor.getString(4);
                String address = cursor.getString(5);
                String gender = cursor.getString(6);
                String dob = cursor.getString(7);
                byte[] profile_picture =  cursor.getBlob(8);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeContacts;
        }

        //adding contacts to db
        public void addContacts (Contact contact){
            ContentValues values = new ContentValues();
            values.put(COLUMN_F_NAME, contact.getF_name());
            values.put(COLUMN_L_NAME, contact.getL_name());
            values.put(COLUMN_EMAIL, contact.getEmail());
            values.put(COLUMN_PHONE, contact.getPhone());
            values.put(COLUMN_ADDRESS, contact.getAddress());
            values.put(COLUMN_GENDER, contact.getGender());
            values.put(COLUMN_DOB, contact.getDob());
            values.put(COLUMN_PROFILE_PICTURE, contact.getProfile_pic());
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_CONTACTS, null, values);
        }

        //updating contacts in the db
        public void updateContacts(Contact contact){
            ContentValues values = new ContentValues();
            values.put(COLUMN_F_NAME, contact.getF_name());
            values.put(COLUMN_L_NAME, contact.getL_name());
            values.put(COLUMN_EMAIL, contact.getEmail());
            values.put(COLUMN_PHONE, contact.getPhone());
            values.put(COLUMN_ADDRESS, contact.getAddress());
            values.put(COLUMN_GENDER, contact.getGender());
            values.put(COLUMN_DOB, contact.getDob());
            values.put(COLUMN_PROFILE_PICTURE, contact.getProfile_pic());
            SQLiteDatabase db = this.getWritableDatabase();
            db.update(TABLE_CONTACTS, values, COLUMN_ID	+ "	= ?", new String[] { String.valueOf(contact.getId())});
        }

        //deleting a contact
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, COLUMN_ID	+ "	= ?", new String[] { String.valueOf(id)});
    }


}

