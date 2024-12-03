/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.cuoc.models;

/**
 *
 * @author Maxte
 */
public class Alumno {
    private int id_alumno, edad;
    private String nombre;

    public Alumno() {
    }

    public Alumno(int id_alumno, int edad, String nombre) {
        this.id_alumno = id_alumno;
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", edad=" + edad + ", nombre=" + nombre + '}';
    }
    
    
}
