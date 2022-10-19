module com.example.trab2gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;

    opens com.example.trab2gui to javafx.fxml;
    opens com.example.trab2gui.models to javafx.fxml;
    opens com.example.trab2gui.dao to javafx.fxml;

    exports com.example.trab2gui;
    exports com.example.trab2gui.models;
    exports com.example.trab2gui.dao;
}