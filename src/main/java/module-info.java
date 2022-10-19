module com.example.trab2gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;


    opens com.example.trab2gui to javafx.fxml;
    exports com.example.trab2gui;
}