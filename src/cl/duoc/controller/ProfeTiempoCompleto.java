/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.controller;

import cl.cuoc.models.Profesor;
import cl.duoc.BD.Conexion;
import cl.duoc.controller.HelperController;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Maxte
 */
public class ProfeTiempoCompleto extends Profesor{
    private double salario;
    
    HelperController helper = new HelperController();
    Conexion cx;

    public ProfeTiempoCompleto() {
        cx = new Conexion();
        cx.conectar();
    }
    
    
    public void guardarProfeTiempoCompleto(Profesor profesor){
        String sql = "INSERT INTO `profesores` (nombre, materia, tipo, salario) VALUE (?, ?, ?, ?)";
        
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(sql);
            st.setString(1, profesor.getNombre());
            st.setString(2, profesor.getMateria());
            
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
    }
    
}
