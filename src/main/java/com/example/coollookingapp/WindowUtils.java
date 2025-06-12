package com.example.coollookingapp;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowUtils {
    private static double initialWindowX;
    private static double initialWindowY;
    private static double initialMouseScreenX;
    private static double initialMouseScreenY;

    public static void moveWindow (Stage stage, Pane titlebar) {
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
}
