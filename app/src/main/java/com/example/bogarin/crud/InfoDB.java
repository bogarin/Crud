package com.example.bogarin.crud;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by jrbogarin on 7/11/15.
 */
public class InfoDB {
    //información de la base de datos
    public static final String TABLE_NAME ="alumnos";
    public static final String STRING_TYPE="text";
    public static final String INT_TYPE= "integer";
    public static String readDatos;

    public static class EncavezadoAlumnos{
        public static final String ID_ALUMNO= BaseColumns._ID;
        public static final String NAME1="Primer nombre";
        public static final String NAME2="segundo nombre";
        public static final String APELLIDOM="Apellido Matenro";
        public static final String APELLIDOP="apellido Paterno";
        public static final String FECHA_NAC="Fecha de Nacimiento";
    }

    //creacion de la talba alumnos
    public static final String CREANDO_TABLA_ALUMNOS= String.format("create table %s(%s %s primary key autoincrement,%s %s not null,%s %snot null,%s %s not null,%s %s not null,%s %s not null)", TABLE_NAME, EncavezadoAlumnos.ID_ALUMNO, INT_TYPE, EncavezadoAlumnos.NAME1, STRING_TYPE, EncavezadoAlumnos.NAME2, STRING_TYPE, EncavezadoAlumnos.APELLIDOP, STRING_TYPE, EncavezadoAlumnos.APELLIDOM, STRING_TYPE, EncavezadoAlumnos.FECHA_NAC, STRING_TYPE);
    // variables para la manipulación de datos
    private SQLiteDatabase database;


    public void insertDatos(String name1,String name2, String apellidop, String apellidom,String fecha){
        readDatos ="inser into"+TABLE_NAME+" values("+"null,"+name1+","+name2+","+apellidop+","+apellidom+","+fecha+")";
    }


}
