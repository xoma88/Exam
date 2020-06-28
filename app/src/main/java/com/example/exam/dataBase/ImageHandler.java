package com.example.exam.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.exam.models.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageHandler extends SQLiteOpenHelper implements ImageBaseHandler<Image>{
    public static final String TABLE_NAME="images";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_URL = "url";

    public ImageHandler(@Nullable Context context){
        super(context,DatabaseSettings.DB_NAME_IMAGE,null,DatabaseSettings.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + " TEXT," +
                KEY_AUTHOR + " TEXT," +
                KEY_AUTHOR_ID + " INTEGER," +
                KEY_DESCRIPTION + " TEXT," +
                KEY_URL + " TEXT" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void create(Image item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());
        values.put(KEY_AUTHOR, item.getAuthor());
        values.put(KEY_AUTHOR_ID, item.getAuthorId());
        values.put(KEY_DESCRIPTION, item.getDescription());
        values.put(KEY_URL, item.getUrl());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public List<Image> getAllImage() {
        List<Image> images = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ImageHandler.TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                Integer id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                Integer authorId = Integer.parseInt(cursor.getString(3));
                String description = cursor.getString(4);
                String url = cursor.getString(5);

                images.add(new Image(id, name, author, authorId, description, url));

            }while (cursor.moveToNext());
        }
        db.close();
        return images;
    }
}
