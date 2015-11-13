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
    }

    public void saveAlumnoRow(Alumno alumno){
        values=new ContentValues();
        values.put(ColumnAlumnos.NOMBRE,alumno.getNombre());
        values.put(ColumnAlumnos.APELLIDOP,alumno.getApellidop());
        values.put(ColumnAlumnos.APELLIDOM,alumno.getApellidom());
        values.put(ColumnAlumnos.FECHANACIMIENTO,alumno.getFechaNacimiento());
        database.insert(TABLE_NAME,null,values);
    }

    public int updateAlumnos(Alumno alumno){
        values=new ContentValues();
        values.put(ColumnAlumnos.NOMBRE,alumno.getNombre());
        values.put(ColumnAlumnos.APELLIDOP,alumno.getApellidop());
        values.put(ColumnAlumnos.APELLIDOM,alumno.getApellidom());
        values.put(ColumnAlumnos.FECHANACIMIENTO, alumno.getFechaNacimiento());
        return database.update(TABLE_NAME, ColumnAlumnos.NUMEROCONTROL + " = ?", new String[]{String.valueOf(alumno.getNumeroControl())});
    }

    public void deleteAlumnosRow(Alumno alumno){
        database.delete(TABLE_NAME, ColumnAlumnos.NUMEROCONTROL + " = ?", new String[]{String.valueOf(alumno.getNumeroControl())});
    }

    public Cursor allAlumnos(){
        return database.rawQuery("select * from "+TABLE_NAME,null);
    }

}
