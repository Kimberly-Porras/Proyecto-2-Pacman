/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pacman;

import factories.JokerFactory;
import factories.RecursosFactory;
import factories.SimpsonsFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.RecursosVisuales;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023
public class JuegoController implements Initializable {

    @FXML
    private ImageView img_pacman;
    @FXML
    private ImageView img_bloque;
    @FXML
    private ImageView img_enemigo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (NivelesController.Nivel == 1) {
            RecursosFactory JF = new JokerFactory();

            RecursosVisuales RV = JF.crearRecursosVisuales();

            Image personaje = RV.obtenerImagenPersonaje();
            Image enemigo = RV.obtenerImagenEnemigo();
            Image bloque = RV.obtenerImagenBloque();

            img_bloque.setImage(bloque);
            img_pacman.setImage(personaje);
            img_enemigo.setImage(enemigo);
        } else {
            if (NivelesController.Nivel == 2) {
                RecursosFactory SF = new SimpsonsFactory();

                RecursosVisuales RV = SF.crearRecursosVisuales();

                Image personaje = RV.obtenerImagenPersonaje();
                Image enemigo = RV.obtenerImagenEnemigo();
                Image bloque = RV.obtenerImagenBloque();

                img_bloque.setImage(bloque);
                img_pacman.setImage(personaje);
                img_enemigo.setImage(enemigo);
            }
        }
    }
}
