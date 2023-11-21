/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.trucable.vistas;

import com.mycompany.trucable.conexion.ConexionBase;
import com.mycompany.trucable.modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 2damb
 */
public class InicioSesionController implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void CambiarVentana(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private TextField fieldUsuario;
    
    @FXML
    private TextField fieldCorreo;
    
    @FXML
    private TextField fieldClave;
    
    @FXML
    void comprobarCredenciales(MouseEvent event) throws IOException, SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet usuarioResult = controlador.datosTabla(conexion);
        while (usuarioResult.next()) {
            Integer id = usuarioResult.getInt("id");
            String usuario = usuarioResult.getString("usuario").trim();
            String correo = usuarioResult.getString("correo").trim();
            String nombre = usuarioResult.getString("nombre").trim();
            String clave = usuarioResult.getString("clave").trim();
            Usuario usuarioClase = new Usuario(id, usuario, correo, nombre, clave);
            usuarios.add(usuarioClase);
}
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getUsuario() + " " + usuario.getClave());
            if (usuario.getUsuario().equals(fieldUsuario.getText()) || usuario.getCorreo().equals(fieldCorreo.getText())) {
                if (usuario.getClave().equals(fieldClave.getText())) {
                    CambiarVentana(new ActionEvent());
                    break;
                }
            }
        }
        System.out.println("Los datos son incorrectos");
    }
}
