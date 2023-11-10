/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

//Universidad Nacional, Campus Coto

import util.Enemigos;
import util.RecursosEnemigos;


//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class Enemigo implements EnemigosFactory{

    @Override
    public Enemigos crearEnemigos() {
        return new RecursosEnemigos();
    }

    
}