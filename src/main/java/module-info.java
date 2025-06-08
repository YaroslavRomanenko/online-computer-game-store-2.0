module com.example.coollookingapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.rmi;

    opens com.example.coollookingapp to javafx.fxml;
    exports com.example.coollookingapp;
}