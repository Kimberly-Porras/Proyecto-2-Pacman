/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pacman;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Nivel2Controller implements Initializable {

    @FXML
    private GridPane gritpane;
    @FXML
    private Label puntos;
    @FXML
    private Label tiempo;
    @FXML
    private Label vidas;
    private String[][] patron = new String[15][15];
    private Descomponer descom = new Descomponer();
    private ImageView pacmanImageView;  // ImageView para la imagen del personaje
    private ImageView blinkyImageView;
    private int pacmanFila;  // Fila actual de Pacman en la matriz
    private int pacmanColumna;  // Columna actual de Pacman en la matriz
    private int blinkyFila;  // Fila actual de Pacman en la matriz
    private int blinkyColumna;  // Columna actual de Pacman en la matriz
    private ImageView pinkyImageView;
    private int pinkyFila;
    private int pinkyColumna;
    private ImageView inkyImageView;
    private int inkyFila;
    private int inkyColumna;
    private ImageView clydeImageView;
    private int clydeFila;
    private int clydeColumna;
    private ScheduledExecutorService scheduler;
    public int puntos1 = 0;
    public int vidas1 = 6;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            patron = descom.descomponerNiveles("Nivel2");
            descom.pintarGridPane(gritpane, patron, 2);

            cargarPersonajes();

            gritpane.setOnKeyPressed(this::manejarEventoTeclado);
            gritpane.setFocusTraversable(true);

            scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(this::MoverFantasmasAleatorio, 0, 5000, TimeUnit.MILLISECONDS);
            scheduler.scheduleAtFixedRate(this::MoverFantasmaAlePinky, 0, 3500, TimeUnit.MILLISECONDS);
            scheduler.scheduleAtFixedRate(this::MoverFantasmaAleInky, 0, 3500, TimeUnit.MILLISECONDS);
            scheduler.scheduleAtFixedRate(this::MoverFantasmaAleClyde, 0, 1500, TimeUnit.MILLISECONDS);

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

            patron[pacmanFila][pacmanColumna] = " ";

            // Actualiza la posición actual de Pacman en la matriz
            pacmanFila = filaNueva;
            pacmanColumna = columnaNueva;

            // Verifica y procesa la fruta en la nueva posición
            verificarYProcesarFruta();
            patron[filaNueva][columnaNueva] = "P";
        }
    }

    private boolean MovimientoValido(int fila, int columna) {
        // Verifica si la nueva posición está dentro de los límites y no es un bloque ('B') ni una casilla de casa fantasma ('V')
        return fila >= 0 && fila < patron.length
                && columna >= 0 && columna < patron[0].length
                && !patron[fila][columna].equals("B")
                && !patron[fila][columna].equals("V");
    }

    private boolean Vidas(int fila, int columna) {
        // Verifica si la nueva posición está dentro de los límites y no es un bloque ('B') ni una casilla de casa fantasma ('V')
        if (fila >= 0 && fila < patron.length && columna >= 0 && columna < patron[0].length) {
            String contenido = patron[fila][columna];

            // Verifica si la casilla no es un bloque ('B') ni una casilla de casa fantasma ('V')
            if (!contenido.equals("O") && !contenido.equals("L") && !contenido.equals("I") && !contenido.equals("J")) {
                // Aquí puedes agregar más lógica según tus necesidades.

                // Llama al método quitarVida() si es necesario.
                if (contenido.equals("0") || contenido.equals("L") || contenido.equals("I") || contenido.equals("J")) {
                    quitarVida();
                }

                return true; // El movimiento es válido
            }
        }

        return false; // El movimiento no es válido
    }

    private void quitarVida() {
        // Reduces el contador de vidas
        vidas1 -= 1;

        // Actualiza el TextField de vidas en la interfaz gráfica
        // Supongamos que tienes un TextField llamado "vidas" para mostrar las vidas.
        vidas.setText(String.valueOf(vidas1));

        // Puedes agregar más lógica aquí, como reiniciar el nivel si las vidas llegan a cero, etc.
    }

    private boolean MovimientoValidoFantasma(int fila, int columna) {
        // Verifica si la nueva posición está dentro de los límites y no es un bloque ('B') ni una casilla de casa fantasma ('V')
        return fila >= 0 && fila < patron.length
                && columna >= 0 && columna < patron[0].length
                && !patron[fila][columna].equals("B");

    }

    private void verificarYProcesarFruta() {
        if (patron[pacmanFila][pacmanColumna].equals("F")) {
            // Elimina la fruta de la matriz
            patron[pacmanFila][pacmanColumna] = " ";

            // Incrementa el contador de puntos
            puntos1 += 6; // Puedes ajustar la cantidad de puntos según desees

            // Actualiza el TextField de puntos
            puntos.setText(String.valueOf(puntos1));

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

    private void MoverFantasmasAleatorio() {
        try {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(4) + 1;

            switch (numeroAleatorio) {
                case 1:
                    moverFantasma(blinkyFila + 3, blinkyColumna);
                    break;
                case 2:
                    moverFantasma(blinkyFila - 3, blinkyColumna);
                    break;
                case 3:
                    moverFantasma(blinkyFila, blinkyColumna - 3);
                    break;
                case 4:
                    moverFantasma(blinkyFila, blinkyColumna + 3);
                    break;
                default:
                // En caso de un valor no esperado, no haces nada o manejas la situación según tus necesidades
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void MoverFantasmaAlePinky() {
        try {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(4) + 1;

            switch (numeroAleatorio) {
                case 1:
                    moverFantasmaPinky(pinkyFila + 2, pinkyColumna);
                    break;
                case 2:
                    moverFantasmaPinky(pinkyFila - 2, pinkyColumna);
                    break;
                case 3:
                    moverFantasmaPinky(pinkyFila, pinkyColumna - 2);
                    break;
                case 4:
                    moverFantasmaPinky(pinkyFila, pinkyColumna + 2);
                    break;
                default:
                // En caso de un valor no esperado, no haces nada o manejas la situación según tus necesidades
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void MoverFantasmaAleInky() {
        try {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(4) + 1;

            switch (numeroAleatorio) {
                case 1:
                    moverFantasmaInky(inkyFila + 4, inkyColumna);
                    break;
                case 2:
                    moverFantasmaInky(inkyFila - 4, inkyColumna);
                    break;
                case 3:
                    moverFantasmaInky(inkyFila, inkyColumna - 4);
                    break;
                case 4:
                    moverFantasmaInky(inkyFila, inkyColumna + 4);
                    break;
                default:
                // En caso de un valor no esperado, no haces nada o manejas la situación según tus necesidades
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void MoverFantasmaAleClyde() {
        try {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(4) + 1;

            switch (numeroAleatorio) {
                case 1:
                    moverFantasmaClyde(clydeFila + 4, clydeColumna);
                    break;
                case 2:
                    moverFantasmaClyde(clydeFila - 4, clydeColumna);
                    break;
                case 3:
                    moverFantasmaClyde(clydeFila, clydeColumna - 4);
                    break;
                case 4:
                    moverFantasmaClyde(clydeFila, clydeColumna + 4);
                    break;
                default:
                // En caso de un valor no esperado, no haces nada o manejas la situación según tus necesidades
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void moverFantasmaInky(int filaNueva, int columnaNueva) {
        Platform.runLater(() -> {
            if (MovimientoValidoFantasma(filaNueva, columnaNueva)) {
                // Elimina el personaje de la posición actual
                gritpane.getChildren().remove(inkyImageView);

                // Añade el personaje a la nueva posición
                gritpane.add(inkyImageView, columnaNueva, filaNueva);

                String posicion = patron[filaNueva][columnaNueva];
                patron[inkyFila][inkyColumna] = posicion;

                // Actualiza la posición actual de Pacman en la matriz
                inkyFila = filaNueva;
                inkyColumna = columnaNueva;

                patron[filaNueva][columnaNueva] = "I";
            }
        });
    }

    private void moverFantasma(int filaNueva, int columnaNueva) {
        Platform.runLater(() -> {
            if (MovimientoValidoFantasma(filaNueva, columnaNueva)) {
                // Elimina el personaje de la posición actual
                gritpane.getChildren().remove(blinkyImageView);

                // Añade el personaje a la nueva posición
                gritpane.add(blinkyImageView, columnaNueva, filaNueva);

                String posicion = patron[filaNueva][columnaNueva];
                patron[blinkyFila][blinkyColumna] = posicion;

                // Actualiza la posición actual de Pacman en la matriz
                blinkyFila = filaNueva;
                blinkyColumna = columnaNueva;

                patron[filaNueva][columnaNueva] = "O";
            }
        });
    }

    private void moverFantasmaClyde(int filaNueva, int columnaNueva) {
        Platform.runLater(() -> {
            if (MovimientoValidoFantasma(filaNueva, columnaNueva)) {
                // Elimina el personaje de la posición actual
                gritpane.getChildren().remove(clydeImageView);

                // Añade el personaje a la nueva posición
                gritpane.add(clydeImageView, columnaNueva, filaNueva);

                String posicion = patron[filaNueva][columnaNueva];
                patron[clydeFila][clydeColumna] = posicion;

                // Actualiza la posición actual de Pacman en la matriz
                clydeFila = filaNueva;
                clydeColumna = columnaNueva;

                patron[filaNueva][columnaNueva] = "J";
            }
        });
    }
    
    private void moverFantasmaPinky(int filaNueva, int columnaNueva) {
        Platform.runLater(() -> {
            if (MovimientoValidoFantasma(filaNueva, columnaNueva)) {
                // Elimina el personaje de la posición actual
                gritpane.getChildren().remove(pinkyImageView);

                // Añade el personaje a la nueva posición
                gritpane.add(pinkyImageView, columnaNueva, filaNueva);

                String posicion = patron[filaNueva][columnaNueva];
                patron[pinkyFila][pinkyColumna] = posicion;

                // Actualiza la posición actual de Pacman en la matriz
                pinkyFila = filaNueva;
                pinkyColumna = columnaNueva;

                patron[filaNueva][columnaNueva] = "L";
            }
        });
    }
    
    public void detenerHilo() {
        scheduler.shutdown();
    }

    private void cargarPersonajes() {

        // Encuentra la posición inicial del personaje 'P' en la matriz
        int[] posicionInicial = encontrarPosicion('P', patron);
        pacmanFila = posicionInicial[0];
        pacmanColumna = posicionInicial[1];

        // Crea un ImageView para la imagen del personaje
        pacmanImageView = new ImageView();
        pacmanImageView.setImage(descom.obtenerImagen("P", 2));  // Obtén la imagen del personaje
        pacmanImageView.setFitWidth(35);  // Ajusta el ancho según sea necesario
        pacmanImageView.setFitHeight(20);  // Ajusta la altura según sea necesario
        // Agrega el ImageView al GridPane en la posición inicial
        gritpane.add(pacmanImageView, pacmanColumna, pacmanFila);

        // Encuentra la posición inicial del fantasma 'O' en la matriz
        int[] posicionInicialBlinky = encontrarPosicion('O', patron);
        blinkyFila = posicionInicialBlinky[0];
        blinkyColumna = posicionInicialBlinky[1];

        // Crea un ImageView para la imagen del fantasma
        blinkyImageView = new ImageView();
        blinkyImageView.setImage(descom.obtenerImagen("O", 2));  // Obtén la imagen del personaje
        blinkyImageView.setFitWidth(35);  // Ajusta el ancho según sea necesario
        blinkyImageView.setFitHeight(20);  // Ajusta la altura según sea necesario
        // Agrega el ImageView al GridPane en la posición inicial
        gritpane.add(blinkyImageView, blinkyColumna, blinkyFila);

        //Fantasma Plinky 'L'
        int[] posicionInicialPinky = encontrarPosicion('L', patron);
        pinkyFila = posicionInicialPinky[0];
        pinkyColumna = posicionInicialPinky[1];

        pinkyImageView = new ImageView();
        pinkyImageView.setImage(descom.obtenerImagen("L", 2));
        pinkyImageView.setFitWidth(35);
        pinkyImageView.setFitHeight(20);
        gritpane.add(pinkyImageView, pinkyColumna, pinkyFila);

        //Fantasma inky 'I'
        int[] posicionInicialIlinky = encontrarPosicion('I', patron);
        inkyFila = posicionInicialIlinky[0];
        inkyColumna = posicionInicialIlinky[1];

        inkyImageView = new ImageView();
        inkyImageView.setImage(descom.obtenerImagen("I", 2));
        inkyImageView.setFitWidth(35);
        inkyImageView.setFitHeight(20);
        gritpane.add(inkyImageView, inkyColumna, inkyFila);

        //Fantasma clyde 'J'
        int[] posicionInicialClyde = encontrarPosicion('J', patron);
        clydeFila = posicionInicialClyde[0];
        clydeColumna = posicionInicialClyde[1];

        clydeImageView = new ImageView();
        clydeImageView.setImage(descom.obtenerImagen("J", 2));
        clydeImageView.setFitWidth(35);
        clydeImageView.setFitHeight(20);
        gritpane.add(clydeImageView, clydeColumna, clydeFila);
    }
}
