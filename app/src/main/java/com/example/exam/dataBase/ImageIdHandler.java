package com.example.exam.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ImageIdHandler extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "imageid";
    public static final String KEY_ID = "id";
    public static final String KEY_COLUMN = "colum";
    public static final String KEY_LINE = "line";
    public static final String KEY_IMAGE_ID = "idImage";

    public ImageIdHandler(@Nullable Context context) {
        super(context, DatabaseSettings.DB_NAME_IMAGE_ID, null, DatabaseSettings.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_COLUMN + " INTEGER," +
                KEY_LINE + " INTEGER," +
                KEY_IMAGE_ID + " INTEGER" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void create(Integer column, Integer line, Integer item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COLUMN, String.valueOf(column));
        values.put(KEY_LINE, String.valueOf(line));
        values.put(KEY_IMAGE_ID, String.valueOf(item));
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Integer[][] getAllImageId() {
        Integer column = 0;
        Integer line = 0;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ImageIdHandler.TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                 column = Integer.parseInt(cursor.getString(1));
                Integer num = Integer.parseInt(cursor.getString(2));
                 if (line < num){
                     line = num;
                 }

            }while (cursor.moveToNext());
        }
        db.close();

        Integer[][] idImage = new Integer[column + 1][line + 1];

        db = getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + ImageIdHandler.TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                Integer id = Integer.parseInt(cursor.getString(0));
                column = Integer.parseInt(cursor.getString(1));
                line = Integer.parseInt(cursor.getString(2));
                Integer item = Integer.parseInt(cursor.getString(3));

                idImage[column][line] = item;

            }while (cursor.moveToNext());
        }
        db.close();

        return idImage;
    }

}
