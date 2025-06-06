package com.example.coollookingapp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    private double initialWindowX;
    private double initialWindowY;
    private double initialMouseScreenX;
    private double initialMouseScreenY;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-panel.fxml"));
        Parent root = loader.load();


        LoginRegisterController controller = loader.getController();
        Pane titlebar = (Pane)root.lookup("#titleBar");

        titlebar.setOnMousePressed(e -> {
            initialWindowX = stage.getX();
            initialWindowY = stage.getY();

            initialMouseScreenX = e.getScreenX();
            initialMouseScreenY = e.getScreenY();
        });

        titlebar.setOnMouseDragged(e -> {
            stage.setX(initialWindowX + (e.getScreenX() - initialMouseScreenX));
            stage.setY(initialWindowY + (e.getScreenY() - initialMouseScreenY));
        });

        stage.setTitle("Login");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setUserAgentStylesheet(getClass().getResource("WhiteTheme.css").toExternalForm());

        stage.setResizable(false);
        stage.setScene(scene);
        controller.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}