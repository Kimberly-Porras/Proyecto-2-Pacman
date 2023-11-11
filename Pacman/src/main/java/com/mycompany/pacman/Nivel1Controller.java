package com.mycompany.pacman;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class Nivel1Controller implements Initializable {

    @FXML
    private GridPane gritpane;
    private Label lblVidas;
    private Label lblPuntos;
    private String[][] patron = new String[15][15];
    private Descomponer descom = new Descomponer();
    private ImageView pacmanImageView;  // ImageView para la imagen del personaje
    private int pacmanFila;  // Fila actual de Pacman en la matriz
    private int pacmanColumna;  // Columna actual de Pacman en la matriz

    public static int vidas = 6;
    public static int puntos = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            patron = descom.descomponerNiveles("Nivel1");
            descom.pintarGridPane(gritpane, patron, 1);

            // Encuentra la posición inicial del personaje 'P' en la matriz
            int[] posicionInicial = encontrarPosicion('P', patron);
            pacmanFila = posicionInicial[0];
            pacmanColumna = posicionInicial[1];

            // Crea un ImageView para la imagen del personaje
            pacmanImageView = new ImageView();
            pacmanImageView.setImage(descom.obtenerImagen("P", 1));  // Obtén la imagen del personaje
            pacmanImageView.setFitWidth(35);  // Ajusta el ancho según sea necesario
            pacmanImageView.setFitHeight(20);  // Ajusta la altura según sea necesario

            // Agrega el ImageView al GridPane en la posición inicial
            gritpane.add(pacmanImageView, pacmanColumna, pacmanFila);

            gritpane.setOnKeyPressed(this::manejarEventoTeclado);
            gritpane.setFocusTraversable(true);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private int[] encontrarPosicion(char elemento, String[][] matriz) {
        // Encuentra las coordenadas de la primera ocurrencia del elemento en la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].equals(String.valueOf(elemento))) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private void manejarEventoTeclado(KeyEvent event) {
        int filaNueva = pacmanFila;
        int columnaNueva = pacmanColumna;

        switch (event.getCode()) {
            case UP:
                filaNueva--;
                break;
            case DOWN:
                filaNueva++;
                break;
            case LEFT:
                columnaNueva--;
                break;
            case RIGHT:
                columnaNueva++;
                break;
        }

        moverPersonaje(filaNueva, columnaNueva);
    }

    private void moverPersonaje(int filaNueva, int columnaNueva) {
        if (MovimientoValido(filaNueva, columnaNueva)) {
            // Elimina el personaje de la posición actual
            gritpane.getChildren().remove(pacmanImageView);

            // Añade el personaje a la nueva posición
            gritpane.add(pacmanImageView, columnaNueva, filaNueva);

            // Actualiza la posición actual de Pacman en la matriz
            pacmanFila = filaNueva;
            pacmanColumna = columnaNueva;

            // Verifica y procesa la fruta en la nueva posición
            verificarYProcesarFruta();
        }
    }

    private boolean MovimientoValido(int fila, int columna) {
        // Verifica si la nueva posición está dentro de los límites y no es un bloque ('B') ni una casilla de casa fantasma ('V')
        return fila >= 0 && fila < patron.length
                && columna >= 0 && columna < patron[0].length
                && !patron[fila][columna].equals("B")
                && !patron[fila][columna].equals("V");
    }

    private void verificarYProcesarFruta() {
        if (patron[pacmanFila][pacmanColumna].equals("F")) {
            // Elimina la fruta de la matriz
            patron[pacmanFila][pacmanColumna] = " ";

            // Busca y elimina la imagen de la fruta en la posición del Pacman
            List<Node> nodosAEliminar = new ArrayList<>();
            for (javafx.scene.Node node : gritpane.getChildren()) {
                if (GridPane.getRowIndex(node) == pacmanFila && GridPane.getColumnIndex(node) == pacmanColumna) {
                    if (node instanceof ImageView && node != pacmanImageView) {
                        nodosAEliminar.add(node);
                    }
                }
            }

            // Elimina los nodos de frutas después de la iteración
            for (Node nodo : nodosAEliminar) {
                gritpane.getChildren().remove(nodo);
            }
        }
    }
}
