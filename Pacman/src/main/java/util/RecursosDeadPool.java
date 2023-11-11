/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javafx.scene.image.Image;

/**
 *
 * @author Melani Barrantes
 */
public class RecursosDeadPool implements RecursosVisuales{

    @Override
    public Image obtenerImagenPersonaje() {
        return new Image("/Imagenes/deadpool.png");
    }

    @Override
    public Image obtenerImagenBloque() {
        return new Image("/Imagenes/ladrilloRojo.png");
    }
}
