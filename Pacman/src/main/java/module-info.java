module com.mycompany.pacman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.pacman to javafx.fxml;
    exports com.mycompany.pacman;
}
