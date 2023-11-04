/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

//Universidad Nacional, Campus Coto

import util.RecursosNaruto;
import util.RecursosVisuales;

//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023

public class NarutoFactory implements RecursosFactory{

    @Override
    public RecursosVisuales crearRecursosVisuales() {
        return new RecursosNaruto();
    }
    
}
