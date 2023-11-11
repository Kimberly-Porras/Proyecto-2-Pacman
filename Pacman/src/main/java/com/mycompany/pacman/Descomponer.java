/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacman;

import factories.BatmanFactory;
import factories.ComidaFactory;
import factories.Comidas;
import factories.DeadPoolFactory;
import factories.DragonBallFactory;
import factories.Enemigo;
import factories.EnemigosFactory;
import factories.IromanFactory;
import factories.JokerFactory;
import factories.NarutoFactory;
import factories.OnePieceFactory;
import factories.RecursosFactory;
import factories.SimpsonsFactory;
import factories.SpidermanFactory;
import factories.SupermanFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import util.Comida;
import util.Enemigos;
import util.RecursosVisuales;

//Universidad Nacional, Campus Coto
//Desarrollado por:
//Joxan Portilla Hernandez
//Melani Barrantes Hidalgo
//Alberto Torres
//Kimberly Porras
//2023
public class Descomponer {

    int filas = 15;
    int colum = 15;

    public static Image imagenPacman = null;

    public String[][] descomponerNiveles(String nivel) throws FileNotFoundException, IOException {

        String[][] temp = new String[filas][colum];

        //Abre el archivo y crea un buffer
        File archivo = new File(nivel + ".txt");
        FileReader fileReader = new FileReader(archivo);
        BufferedReader bufferLectura = new BufferedReader(fileReader);

        if (archivo.exists()) {
            for (int i = 0; i < filas; i++) {
                String linea = bufferLectura.readLine(); //Lee linea por linea
                if (linea != null) {
                    String[] partes = linea.split("\\|"); //Divide cada letra agregandola una por una en partes

                    for (int j = 0; j < colum; j++) {
                        temp[i][j] = partes[j + 1].trim(); //Agrega las letras a la matriz quitando los espacios en blancos.
                    }
                }
            }
        } else {
            return null;
        }
        bufferLectura.close();

        return temp;
    }

    public void pintarGridPane(GridPane gp, String[][] escena, int nivel) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < colum; j++) {
                String valor = escena[i][j];
                Image imagen = null;

                if (valor.equals("P")) {
                    // Si el valor es "P" (Pacman), no crea la ImageView y no la agrega al GridPane
                    continue;
                }

                imagen = obtenerImagen(valor, nivel);
                ImageView imageView = new ImageView(imagen);

                double celdaWidth;
                double celdaHeigth;

                if (valor.equals("B")) {
                    celdaWidth = 45;
                    celdaHeigth = 33;
                } else {
                    if (valor.equals("S")) {
                        celdaWidth = 35;
                        celdaHeigth = 20;
                    } else {
                        if (valor.equals("F")) {
                            celdaWidth = 30;
                            celdaHeigth = 21;
                        } else {
                            if (valor.equals("O") || valor.equalsIgnoreCase("L") || valor.equals("I") || valor.equals("J")) {
                                celdaWidth = 35;
                                celdaHeigth = 24;
                            } else {
                                celdaWidth = 42;
                                celdaHeigth = 33;
                            }
                        }
                    }
                }

                imageView.setFitWidth(celdaWidth);
                imageView.setFitHeight(celdaHeigth);

                gp.add(imageView, j, i);
            }
        }
    }

    public Image obtenerImagen(String valor, int nivel) {
        Image imagen = null;

        switch (nivel) {
            case 1:
                RecursosFactory FabricaJ = new JokerFactory();

                RecursosVisuales RJoker = FabricaJ.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RJoker.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RJoker.obtenerImagenPersonaje();
                    }
                }
                break;
            case 2:
                RecursosFactory FabricaS = new SimpsonsFactory();

                RecursosVisuales RSimpson = FabricaS.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RSimpson.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RSimpson.obtenerImagenPersonaje();
                    }
                }
                break;
            case 3:
                RecursosFactory FabricaI = new IromanFactory();

                RecursosVisuales RIroman = FabricaI.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RIroman.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RIroman.obtenerImagenPersonaje();
                    }
                }
                break;
            case 4:
                RecursosFactory FabricaSP = new SpidermanFactory();

                RecursosVisuales RSpiderman = FabricaSP.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RSpiderman.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RSpiderman.obtenerImagenPersonaje();
                    }
                }
                break;
            case 5:
                RecursosFactory FabricaB = new BatmanFactory();

                RecursosVisuales RBatman = FabricaB.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RBatman.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RBatman.obtenerImagenPersonaje();
                    }
                }
                break;
            case 6:
                RecursosFactory FabricaSPM = new SupermanFactory();

                RecursosVisuales RSuperman = FabricaSPM.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RSuperman.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RSuperman.obtenerImagenPersonaje();
                    }
                }
                break;
            case 7:
                RecursosFactory FabricaD = new DeadPoolFactory();

                RecursosVisuales RDeadPool = FabricaD.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RDeadPool.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RDeadPool.obtenerImagenPersonaje();
                    }
                }
                break;
            case 8:
                RecursosFactory FabricaO = new OnePieceFactory();

                RecursosVisuales ROnePiece = FabricaO.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = ROnePiece.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = ROnePiece.obtenerImagenPersonaje();
                    }
                }
                break;
            case 9:
                RecursosFactory FabricaN = new NarutoFactory();

                RecursosVisuales RNaruto = FabricaN.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RNaruto.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RNaruto.obtenerImagenPersonaje();
                    }
                }
                break;
            case 10:
                RecursosFactory FabricaDB = new DragonBallFactory();

                RecursosVisuales RDragonBall = FabricaDB.crearRecursosVisuales();

                if (valor.equals("B")) {
                    return imagen = RDragonBall.obtenerImagenBloque();
                } else {
                    if (valor.equals("P")) {
                        return imagen = RDragonBall.obtenerImagenPersonaje();
                    }
                }
                break;
        }

        imagen = pintarEscenario(valor);
        return imagen;
    }

    public Image pintarEscenario(String valor) {
        Image imagen = null;

        EnemigosFactory FabricaE = new Enemigo();
        ComidaFactory FabricaC = new Comidas();

        Enemigos REnemigo = FabricaE.crearEnemigos();
        Comida RComida = FabricaC.crearComida();

        if (valor.equals("O")) {
            return imagen = REnemigo.obtenerEnemigo(1);
        } else {
            if (valor.equals("L")) {
                return imagen = REnemigo.obtenerEnemigo(2);
            } else {
                if (valor.equals("I")) {
                    return imagen = REnemigo.obtenerEnemigo(3);
                } else {
                    if (valor.equals("J")) {
                        return imagen = REnemigo.obtenerEnemigo(4);
                    } else {
                        if (valor.equals("F")) {
                            return imagen = RComida.obtenerImagenFruta(1);
                        } else {
                            if (valor.equals("S")) {
                                return imagen = RComida.obtenerImagenFruta(2);
                            } else {
                                if (valor.equals("D")) {
                                    return imagen = RComida.obtenerImagenFruta(3);
                                } else {
                                    if (valor.equals("M")) {
                                        return imagen = RComida.obtenerImagenFruta(4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
