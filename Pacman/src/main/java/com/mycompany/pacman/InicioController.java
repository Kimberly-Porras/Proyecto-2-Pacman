/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pacman;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023
public class InicioController implements Initializable {

    @FXML
    private TextField txtNombreJugador;
    @FXML
    private ComboBox<String> cbxModoJuego;
    
    public static int modoJuego = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNombreJugador.setFocusTraversable(false);
        cbxModoJuego.getItems().addAll("Tiempo", "Ninguno");
    }

    @FXML
    private void btnIniciarPartida(ActionEvent event) throws IOException {
        if(cbxModoJuego.getValue().equals("Tiempo")){
            modoJuego = 1;
        }else{
            modoJuego = 0;
        }
        App.setRoot("Niveles");
    }

    @FXML
    private void btnConfiguraciones(ActionEvent event) {
    }

    @FXML
    private void btnSalir(ActionEvent event) {
        System.exit(0);
    }
}