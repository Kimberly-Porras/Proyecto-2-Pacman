package com.mycompany.pacman;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class CargaJuegoController implements Initializable {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar la barra de progreso y el botón
        progressBar.setProgress(0.0);

        startButton.setOnAction(e -> iniciarProceso());
    }

    private void iniciarProceso() {
        // Simulación de un proceso que toma tiempo
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            progressBar.setProgress((double) i / 100);
        }
    }
}
