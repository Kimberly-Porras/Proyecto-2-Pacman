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
import javafx.scene.image.ImageView;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class NivelesController implements Initializable {

    @FXML
    private Button bntNIvel10;
    @FXML
    private ImageView btnRegresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bntNIvel1(ActionEvent event) throws IOException {
        App.setRoot("Nivel 1");
    }

    @FXML
    private void bntNIvel2(ActionEvent event) throws IOException {
    }

    @FXML
    private void bntNIvel3(ActionEvent event) {
    }

    @FXML
    private void bntNIvel4(ActionEvent event) {
    }

    @FXML
    private void bntNIvel5(ActionEvent event) {
    }

    @FXML
    private void bntNIvel6(ActionEvent event) {
    }

    @FXML
    private void bntNIvel7(ActionEvent event) {
    }

    @FXML
    private void bntNIvel8(ActionEvent event) {
    }

    @FXML
    private void bntNIvel9(ActionEvent event) {
    }
}
