/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javafx.scene.image.Image;

//Universidad Nacional, Campus Coto

//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class RecursosSimpsons implements RecursosVisuales{

    @Override
    public Image obtenerImagenPersonaje() {
        return new Image("/Imagenes/Homero.png");
    }
    
    @Override
    public Image obtenerImagenBloque() {
        return new Image("/Imagenes/LadrilloPapaya.png");
    }
}