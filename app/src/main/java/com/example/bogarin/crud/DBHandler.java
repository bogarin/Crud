package com.example.bogarin.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jrbogarin on 13/11/15.
 */
public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME="ControlAlumnos.db";
    public static final int DB_VERSION=1;

    public DBHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QueryScriptAlumnos.CREACION_SCRIPT);
        db.execSQL(QueryScriptAlumnos.INSERTAR_DEFAULT_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(QueryScriptAlumnos.EXISTS_TABLE_SCRIPT);
        onCreate(db);
    }
}
