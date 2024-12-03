/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package preparacionpruebafinal;

import cl.duoc.BD.Conexion;
import cl.duoc.viwes.Menu;

/**
 *
 * @author Maxte
 */
public class PreparacionPruebaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion entrada = new Conexion();
        entrada.conectar();
        
        Menu menu = new Menu();
        menu.setVisible(true);
    }
    
}
