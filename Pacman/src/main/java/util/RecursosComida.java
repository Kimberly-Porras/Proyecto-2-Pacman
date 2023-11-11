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

public class RecursosComida implements Comida{

    @Override
    public Image obtenerImagenFruta(int valor) {
        Image imagen = null;
        
        switch(valor){
            case 1:
                imagen = new Image("/Imagenes/cereza.png");
                break;
            case 2:
                imagen = new Image("/Imagenes/rayo.png");
                break;
            case 3:
                imagen = new Image("/Imagenes/sirena.png");
                break;
            case 4:
                imagen = new Image("/Imagenes/estrella.png");
                break;
        }
        return imagen;
    }   
}
