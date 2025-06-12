module com.example.coollookingapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.rmi;
    requires java.sql;
    requires spring.security.crypto;
    requires com.fasterxml.jackson.databind;

    opens com.example.coollookingapp to javafx.fxml;
    exports com.example.coollookingapp;
    exports com.example.coollookingapp.controllers;
    opens com.example.coollookingapp.controllers to javafx.fxml;
}