package com.example.exam.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.exam.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserHandler extends SQLiteOpenHelper implements UserBaseHandler<User> {
    public static final String TABLE_NAME = "users";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_AUTHORIZED = "authorized";

    public UserHandler(@Nullable Context context) {
        super(context, DatabaseSettings.DB_NAME_USER, null, DatabaseSettings.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + " TEXT," +
                KEY_EMAIL + " TEXT," +
                KEY_LOGIN + " INTEGER," +
                KEY_PASSWORD + " INTEGER," +
                KEY_AUTHORIZED + " BOOLEAN" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void create(User item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());
        values.put(KEY_EMAIL, item.getEmail());
        values.put(KEY_LOGIN, item.getLogin());
        values.put(KEY_PASSWORD, item.getPassword());
        values.put(KEY_AUTHORIZED, item.getAuthorized());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public List<User> getAllUser(Integer[][] imageId) {
        List<User> users = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + UserHandler.TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                Integer id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String login = cursor.getString(3);
                String password = cursor.getString(4);
                Boolean authorized = Boolean.valueOf(cursor.getString(5));

                users.add(new User(id, name, email, imageId[id-1], login, password, authorized));

            }while (cursor.moveToNext());
        }
        db.close();
        return users;
    }
}
