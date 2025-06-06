package com.example.coollookingapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginRegisterController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private TextField textLogin;

    @FXML
    private TextField textPassword;

    @FXML
    private Button singIn;

    @FXML
    private Button singOut;

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
    protected void handleMinimizeBtnClick() {
        if (stage != null) {
            stage.setIconified(true);
        }
    }

}