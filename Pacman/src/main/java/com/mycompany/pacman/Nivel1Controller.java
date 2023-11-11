package com.mycompany.pacman;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class Nivel1Controller implements Initializable {

    @FXML
    private GridPane gritpane;
    public  String[][] patron = new String[15][15];
    Descomponer descom = new Descomponer();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            patron = descom.descomponerNiveles("Nivel1");
            descom.pintarGridPane(gritpane, patron, 1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
