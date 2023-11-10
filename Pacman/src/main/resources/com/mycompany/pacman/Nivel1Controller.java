import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Nivel1Controller implements Initializable {

    @FXML
    private GridPane gritpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            leerArchivoYMostrarEnGrid("Nivel1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leerArchivoYMostrarEnGrid(String filePath) throws IOException {
        // Crear un BufferedReader para leer el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;

            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en caracteres
                char[] chars = line.toCharArray();

                // Mostrar cada carácter en celdas consecutivas en la misma fila
                for (int col = 0; col < chars.length; col++) {
                    Label label = new Label(String.valueOf(chars[col]));
                    asignarColorAleatorio(label, chars[col]);
                    gritpane.add(label, col, row);
                }

                // Ir a la siguiente fila
                row++;
            }
        }
    }

    private void asignarColorAleatorio(Label label, char character) {
        // Lógica de asignación de colores aleatorios, similar a la función anterior
        // Puedes copiar la función asignarColorAleatorio de mi respuesta anterior
    }
}
