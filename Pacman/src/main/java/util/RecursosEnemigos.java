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

public class RecursosEnemigos implements Enemigos{

    @Override
    public Image obtenerEnemigo(int numeroEnemigo) {
        Image image = null;
        
        switch(numeroEnemigo){
            case 1:
                image = new Image("/Imagenes/blinky.png");
                break;
            case 2:
                image = new Image("/Imagenes/pinky.png");
                break;
            case 3:
                image = new Image("/Imagenes/inky.png");
                break;
            case 4:
                image = new Image("/Imagenes/clyde.png");
                break;
        }
        return image;
    }
}
