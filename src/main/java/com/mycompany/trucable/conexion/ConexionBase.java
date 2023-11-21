/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trucable.conexion;

import com.mycompany.trucable.modelo.Usuario;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class ConexionBase {
    public ConexionBase() {}
    
    public Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://igluser.database.windows.net\\prueba:1433;databaseName=SwapSnap;encrypt=true;trustServerCertificate=true;",
                    "iglu", "30606933Eri");
            System.out.println("Conexion exitosa");
            return conexion;
        } catch (SQLException ex) {
            System.out.println("conexion Fallida");
            Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }  
    
    public ResultSet datosTabla(Connection conexion) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Usuarios");
        return resultado;
    }
}
