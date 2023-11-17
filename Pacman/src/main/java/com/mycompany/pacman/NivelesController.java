/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pacman;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class NivelesController implements Initializable {

    @FXML
    private ImageView btnRegresar;
    public static int Vidas = 6;
    public static int Puntos = 0;
    @FXML
    private Label lblPuntos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        lblPuntos.setText(Puntos + "");
    }    
    
    

    @FXML
    private void bntNIvel1(ActionEvent event) throws IOException {
        App.setRoot("Nivel 1");
    }

    @FXML
    private void bntNIvel2(ActionEvent event) throws IOException {
        App.setRoot("Nivel2");
    }

    @FXML
    private void bntNIvel3(ActionEvent event) throws IOException {
        App.setRoot("Nivel3");
    }

    @FXML
    private void bntNIvel4(ActionEvent event) throws IOException {
        App.setRoot("Nivel4");
    }

    @FXML
    private void bntNIvel5(ActionEvent event) throws IOException {
         App.setRoot("Nivel5");
    }

    @FXML
    private void bntNIvel6(ActionEvent event) throws IOException {
         App.setRoot("Nivel6");
    }

    @FXML
    private void bntNIvel7(ActionEvent event) throws IOException {
         App.setRoot("Nivel7");
    }

    @FXML
    private void bntNIvel8(ActionEvent event) throws IOException {
         App.setRoot("Nivel8");
    }

    @FXML
    private void bntNIvel9(ActionEvent event) throws IOException {
         App.setRoot("Nivel9");
    }

    @FXML
    private void bntNIvel10(ActionEvent event) throws IOException {
        App.setRoot("Nivel10");
    }

     @FXML
    private void Back(MouseEvent event) throws IOException {
        
        App.setRoot("Niveles");
    }
}
