/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

//Universidad Nacional, Campus Coto

import javafx.scene.image.Image;

//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class RecursosDragonBallZ implements RecursosVisuales{

    @Override
    public Image obtenerImagenPersonaje() {
        return new Image("/Imagenes/goku.png");
    }

    @Override
    public Image obtenerImagenBloque() {
        return new Image("/Imagenes/ladrilloAzul.png");
    }
}
