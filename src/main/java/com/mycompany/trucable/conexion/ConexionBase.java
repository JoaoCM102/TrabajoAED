/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trucable.conexion;

import com.mycompany.trucable.modelo.Producto;
import com.mycompany.trucable.modelo.Usuario;
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
    
    public ResultSet datosProductos(Connection conexion) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Productos");
        return resultado;
    }
    
    public ResultSet obtenerUsuario(Connection conexion, String usuario) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from usuarios where usuario == '" + usuario + "'");
        return resultado;
    }
    
    public ResultSet obtenerProductoUsuario(Connection conexion, int id) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Productos where idUsuario == '" + id + "'");
        return resultado;
    }
    
    public ResultSet obtenerProducto(Connection conexion, int id) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Productos where id == '" + id + "'");
        return resultado;
    }
    
    public void crearProducto(Connection conexion, Producto producto) throws SQLException {
        Statement consulta = conexion.createStatement();
        String productosDemandados = "";
        for (String productoDemandado : producto.getDemanda()) {
            productosDemandados += productoDemandado;
        }
        consulta.executeQuery("INSERT INTO Productos VALUES (" + producto.getNombre() + ", " 
                + producto.getDescripcion() + ", " + productosDemandados + ", " + producto.isDisponible() 
                + ", " + producto.getIdUsuario() + ")");
    }
    
    public void crearUsuario(Connection conexion, Usuario usuario) throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeQuery("INSERT INTO Usuarios VALUES (" + usuario.getUsuario() + ", " 
                + usuario.getCorreo() + ", " + usuario.getNombre() + ", " + usuario.getClave() + ")");
    }
}
