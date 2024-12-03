/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc.BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Maxte
 */

public class Conexion {

    String bd = "pruebafinal";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String pass = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    
    Connection cx;
    public com.mysql.cj.xdevapi.Statement createStatement;
    
    
    
    public void conectar() {
    try {
      Class.forName(driver);
      cx = DriverManager.getConnection(url, user, pass);
      System.out.println("Conexión exitosa");
    }catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
    }

   }

  public void desconectar(){
    try {
      cx.close();
      System.out.println("Desconexión exitosa");
    } catch (Exception e) {
      System.out.println("Error desconectando de la BD: - " );
    }

  }


  public ResultSet EjecutarQuery(String query) throws SQLException {
      Statement st = cx.createStatement();
      return st.executeQuery(query);

  }


  public Connection getConnection(){
    return cx;
  }

    public com.mysql.cj.xdevapi.Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    


   
}
