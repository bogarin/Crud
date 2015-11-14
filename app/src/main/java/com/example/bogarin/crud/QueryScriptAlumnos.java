package com.example.bogarin.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by jrbogarin on 13/11/15.
 */
public class QueryScriptAlumnos {
    private ContentValues values;
    public static final String TABLE_NAME="Alumnos";
    public static final String STRING_TYPE="text";
    public static final String INT_TYPE="integer";

    public static class ColumnAlumnos{
        public static final String NUMEROCONTROL= BaseColumns._ID;
        public static final String NOMBRE="nombre";
        public static final String APELLIDOP="apellidop";
        public static final String APELLIDOM="apellidom";
        public static final String FECHANACIMIENTO="fechaNac";
    }


    public static final String    CREACION_SCRIPT = "create table " + TABLE_NAME + "("
                + ColumnAlumnos.NUMEROCONTROL + " " + INT_TYPE + " primary key autoincrement," +
                ColumnAlumnos.NOMBRE + " " + STRING_TYPE + " not null," +
                ColumnAlumnos.APELLIDOP + " " + STRING_TYPE + "not null," +
                ColumnAlumnos.APELLIDOM + " " + STRING_TYPE + "not  null," +
                ColumnAlumnos.FECHANACIMIENTO + " " + STRING_TYPE + " not null)";
    public static final String INSERTAR_DEFAULT_SCRIPT= String.format("insert into %svalues(null,\"Jose Ramón\",\"Bogarin\",\"Valenzuela\",null", TABLE_NAME);
    public static final String EXISTS_TABLE_SCRIPT="drop table if exists "+TABLE_NAME;

    private DBHandler dbHandler;
    private SQLiteDatabase database;

    public QueryScriptAlumnos(Context context){
        dbHandler=new DBHandler(context);
        database=dbHandler.getWritableDatabase();
        values=new ContentValues();
    }

    public void saveAlumnoRow(String nombre,String apellidop,String apellidom,String fechaNacimiento){
        values=null;
        values.put(ColumnAlumnos.NOMBRE,nombre);
        values.put(ColumnAlumnos.APELLIDOP,apellidop);
        values.put(ColumnAlumnos.APELLIDOM,apellidom);
        values.put(ColumnAlumnos.FECHANACIMIENTO,fechaNacimiento);
        database.insert(TABLE_NAME,null,values);
    }

   public int updateAlumnos(int numero,String nombre,String apellidop,String apellidom,String fechaNacimiento){
        values=null;
        values.put(ColumnAlumnos.NOMBRE,nombre);
        values.put(ColumnAlumnos.APELLIDOP,apellidop);
        values.put(ColumnAlumnos.APELLIDOM,apellidom);
        values.put(ColumnAlumnos.FECHANACIMIENTO,fechaNacimiento);
        return database.update(TABLE_NAME, values,ColumnAlumnos.NUMEROCONTROL+ " = "+numero,null);
    }

    public void deleteAlumnosRow(int numero) {
        database.delete(TABLE_NAME, ColumnAlumnos.NUMEROCONTROL + " = "+numero,null);
    }

    public Cursor allAlumnos(){
        return database.rawQuery("select nombre, apellidop from "+TABLE_NAME,null);
    }

}
