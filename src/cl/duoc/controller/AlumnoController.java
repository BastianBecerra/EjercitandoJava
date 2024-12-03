/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.controller;

import cl.cuoc.models.Alumno;
import cl.duoc.BD.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxte
 */
public class AlumnoController {
    HelperController helper = new HelperController();
    Conexion cx;
    
    public AlumnoController(){
        cx = new Conexion();
        cx.conectar();
    }
    
    public void AgregarAlumno(String parNombre, int edad){
        String sql = "INSERT INTO `alumnos` (nombre, edad) VALUE (?, ?)";
        
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(sql);
            st.setString(1, parNombre);
            st.setInt(2, edad);
            st.executeUpdate();
            helper.showInformation("Alumno agregado con exito");
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
    }
    
    public List<Alumno> ListarAlumno(){
        List<Alumno> listar = new ArrayList<>();
        try {
            ResultSet rs = cx.EjecutarQuery("SELECT * FROM `alumnos`");
            while(rs.next()){
                listar.add(new Alumno(rs.getInt("id_alumno"),
                rs.getInt("edad"),
                rs.getString("nombre")));
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }return listar;
    }
    
    public Alumno buscarAlumnoPorId(int id){
        Alumno alumnoEncontrado = null;
        String query = "SELECT * FROM `alumnos` WHERE id_alumno="+ id+ ";";
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            if(rs.next()){
                alumnoEncontrado = new Alumno();
                alumnoEncontrado.setId_alumno(rs.getInt("id_alumno"));
                alumnoEncontrado.setNombre(rs.getString("nombre"));
                alumnoEncontrado.setEdad(rs.getInt("edad"));
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return alumnoEncontrado;
    }
    
    public boolean editarAlumno(int id_alumno, String nombre, int edad){
        String sql = "UPDATE `alumnos` SET nombre = '" + nombre + "', edad = " + edad + " WHERE id_alumno = " + id_alumno + ";";
        
        System.out.println(sql);
        
        try {
            Alumno alumnoEncontrado = buscarAlumnoPorId(id_alumno);
            if(alumnoEncontrado != null){
                Statement st = cx.getConnection().createStatement();
                int filasAfectadas = st.executeUpdate(sql);
                helper.showInformation("Alumno Actualizado!");
                return filasAfectadas > 0;
            }else{
                helper.showError("Alumno no encorntrado!");
                return false;
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return false;
        
    }
    
    public boolean eliminarAlumno(int id_alumno){
        String sql = "DELETE FROM `alumnos` WHERE id_alumno = '" + id_alumno + "';";
        
        try {
            Alumno alumnoEncontrado = buscarAlumnoPorId(id_alumno);
            if(alumnoEncontrado != null){
                Statement st = cx.getConnection().createStatement();
                int filasAfectadas = st.executeUpdate(sql);
                helper.showInformation("Alumno encontrado y Eliminado");
                return filasAfectadas > 0;
            }else{
                helper.showError("Alumno no encontrado!");
                return false;
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return false;
    }
    
    
    
}
