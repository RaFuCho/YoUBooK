package com.example.youbook;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.content.Context;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper(@Nullable Context context,@Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE USUARIOS(USER TEXT PRIMARY KEY, NOM TEXT, GEN TEXT, PASS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS USUARIOS");

        db.execSQL("CREATE TABLE USUARIOS(USER TEXT PRIMARY KEY, NOM TEXT, GEN TEXT, PASS TEXT)");
    }
}
