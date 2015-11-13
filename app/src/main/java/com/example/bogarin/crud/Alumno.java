package com.example.bogarin.crud;

/**
 * Created by jrbogarin on 13/11/15.
 */
public class Alumno {
    private int numeroControl;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String fechaNacimiento;

    public Alumno(){
        numeroControl=0;
        nombre ="";
        apellidop="";
        apellidom="";
        fechaNacimiento="";
    }

    public Alumno(int numeroControl,String nombre, String apellidop,String apellidom,String fechaNacimiento){
        this.numeroControl=numeroControl;
        this.nombre=nombre;
        this.apellidop=apellidop;
        this.apellidom=apellidom;
        this.fechaNacimiento=fechaNacimiento;
    }

    public void setNumeroControl(int numeroControl){
        this.numeroControl=numeroControl;
    }

    public int getNumeroControl(){
        return numeroControl;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellidop(String apellidop){
        this.apellidop=apellidop;
    }

    public String getApellidop(){
        return apellidop;
    }

    public void setApellidom(String apellidom){
        this.apellidom=apellidom;
    }

    public String getApellidom(){
        return apellidom;
    }

    public void setFechaNacimiento(int fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }

    public int getFechaNacimiento(){
        return fechaNacimiento;
    }
}
