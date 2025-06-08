package com.example.coollookingapp;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginRegisterController {
    private Stage primaryStage;

    public void setStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    private TextField textLogin;

    @FXML
    private TextField textPassword;

    @FXML
    private Button singIn;

    @FXML
    private Button registerButton;

    @FXML
    private StackPane exitButton;

    @FXML
    private StackPane minimizeButton;

    @FXML
    protected void handleExitBtnClick() {
        if (exitButton.getScene() != null && exitButton.getScene().getWindow() != null) {
            Stage stage = (Stage)exitButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    protected void handleMinimizeBtnClick(MouseEvent e) {
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    protected void handleRegisterBtnClick() {
    }

}