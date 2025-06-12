package com.example.coollookingapp;

import com.example.coollookingapp.controllers.LoginRegisterController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    private static double initialWindowX;
    private static double initialWindowY;
    private static double initialMouseScreenX;
    private static double initialMouseScreenY;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-panel.fxml"));
        Parent root = loader.load();

        LoginRegisterController controller = loader.getController();
        Pane titlebar = (Pane)root.lookup("#titleBar");

        WindowUtils.moveWindow(stage, titlebar);
        // minimizeWindow(stage);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        scene.setUserAgentStylesheet(getClass().getResource("WhiteLogRegStyle.css").toExternalForm());

        stage.setTitle("Login");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }

    private static void minimizeWindow(Stage stage) {
        stage.iconifiedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                Platform.runLater(() -> {
                    stage.setIconified(false);
                    stage.toFront();
                    stage.requestFocus();
                });
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}