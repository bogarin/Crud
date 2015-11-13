package com.example.bogarin.crud;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jrbogarin on 13/11/15.
 */
public class DBHandler extends SQLiteOpenHelper {

    public satic final String DB_NAME="ControlAlumnos.db";
    public static final int DB_VERSION=1;
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
