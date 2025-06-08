package com.example.coollookingapp;

import javafx.application.Application;
import javafx.application.Platform;
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

        moveWindow(stage, titlebar);
        // minimizeWindow(stage);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        scene.setUserAgentStylesheet(getClass().getResource("WhiteTheme.css").toExternalForm());

        stage.setTitle("Login");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(scene);

        controller.setStage(stage);

        stage.show();
    }

    private static void moveWindow (Stage stage, Pane titlebar) {
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