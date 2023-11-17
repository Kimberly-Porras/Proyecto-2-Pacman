/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023
public class Tiempo {

    private Duration tiempoTranscurrido;
    Timeline timeline;
    private boolean corriendo;

    public Tiempo() {
        tiempoTranscurrido = Duration.ZERO;
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tiempoTranscurrido = tiempoTranscurrido.add(Duration.seconds(1));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        corriendo = false;
    }

    public Tiempo(Duration tiempoInicial) {
        tiempoTranscurrido = tiempoInicial;
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tiempoTranscurrido = tiempoTranscurrido.add(Duration.seconds(1));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        corriendo = false;
    }

    public void iniciarTiempo() {
        if (!corriendo) {
            timeline.play();
            corriendo = true;
        }
    }

    public void detenerTiempo() {
        if (corriendo) {
            timeline.pause();
            corriendo = false;
        }
    }

    public void reiniciarTiempo() {
        timeline.stop();
        tiempoTranscurrido = Duration.ZERO;
    }

    public String obtenerTiempoFormateado() {
        long segundos = (long) tiempoTranscurrido.toSeconds();
        long minutos = segundos / 60;
        segundos = segundos % 60;
        long horas = minutos / 60;
        minutos = minutos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
    
    public Duration getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }
}