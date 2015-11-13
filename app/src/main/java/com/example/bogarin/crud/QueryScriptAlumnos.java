package com.example.bogarin.crud;

import android.provider.BaseColumns;

/**
 * Created by jrbogarin on 13/11/15.
 */
public class QueryScriptAlumnos {
    public static final String TABLE_NAME="Alumnos";
    public static final String STRING_TYPE="text";
    public static final String INT_TYPE="integer";
    public static final String CREACION_SCRIPT;
    public static final String INSERTAR_DEFAULT_SCRIPT;

    public static class ColumnAlumnos{
        public static final String NUMEROCONTROL= BaseColumns._ID;
        public static final String NOMBRE="nombre";
        public static final String APELLIDOP="apellidop";
        public static final String APELLIDOM="apellidom";
        public static final String FECHANACIMIENTO="fechaNac";
    }

    static {
        CREACION_SCRIPT = "create table " + TABLE_NAME + "("
                + ColumnAlumnos.NUMEROCONTROL + " " + INT_TYPE + " primary key autoincrement," +
                ColumnAlumnos.NOMBRE + " " + STRING_TYPE + " not null," +
                ColumnAlumnos.APELLIDOP + " " + STRING_TYPE + "not null," +
                ColumnAlumnos.APELLIDOM + " " + STRING_TYPE + "not  null," +
                ColumnAlumnos.FECHANACIMIENTO + " " + STRING_TYPE + " not null)";

        INSERTAR_DEFAULT_SCRIPT= String.format("insert into %svalues(null,\"Jose Ramón\",\"Bogarin\",\"Valenzuela\",null", TABLE_NAME);
    }




}
