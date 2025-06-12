package com.example.coollookingapp.controllers;

import com.example.coollookingapp.DataBaseManager;
import com.example.coollookingapp.WindowUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class LoginRegisterController {
    private Connection connection;

    public void setConnection(Connection connection) { this.connection = connection; };

    @FXML
    private TextField textLogLogin;

    @FXML
    private TextField textLogPassword;

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
    protected void handleSignInBtnClick(MouseEvent e) {
//        String username = textLogLogin.getText();
//        String password = textLogPassword.getText();
//
//        if (username == "" || password == "") {
//            System.out.println("Password or Login field is empty");
//            return;
//        }
//
//        boolean isLogInSuccessful;
//
//        try {
//            isLogInSuccessful = DataBaseManager.userLoginVerification(connection, username, password);
//        } catch(Exception exc) {
//            System.out.println(exc);
//            return;
//        }
//
//        if (!isLogInSuccessful) {
//            System.out.println("Error");
//            Alert errorBox = new Alert(Alert.AlertType.ERROR);
//            errorBox.setTitle("Error");
//            errorBox.setContentText("Log in is failed! Try again!");
//            return;
//        }

        String fxmlFilePath = "/com/example/coollookingapp/store/store-panel.fxml";
        String cssFilePath = "/com/example/coollookingapp/store/WhiteStoreStyle.css";

        try {
            switchScene(e, fxmlFilePath, cssFilePath);
        }
        catch (Exception exc) {
            System.out.println("Can't switch to the scene in the " + fxmlFilePath + " Error code: " + exc.getMessage());
        }

    }

    @FXML
    protected void handleRegisterBtnClick(MouseEvent e) {
        String fxmlFilePath = "/com/example/coollookingapp/registration-panel.fxml";
        String cssFilePath = "/com/example/coollookingapp/WhiteLogRegStyle.css";

        try {
            switchScene(e, fxmlFilePath, cssFilePath);
        } catch (Exception exc) {
            System.out.println("Can't switch to the scene in the " + fxmlFilePath + " Error code: " + exc.getMessage());
        }
    }

    @FXML
    protected void handleLogInBtnClick(MouseEvent e) {
        String fxmlFilePath = "/com/example/coollookingapp/login-panel.fxml";
        String cssFilePath = "/com/example/coollookingapp/WhiteLogRegStyle.css";

        try {
            switchScene(e, fxmlFilePath, cssFilePath);
        } catch (Exception exc) {
            System.out.println("Can't switch to the scene in the " + fxmlFilePath + " Error code: " + exc.getMessage());
        }
    }

    private void switchScene(MouseEvent e, String fxmlFileName, String styleFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = loader.load();

        Pane titlebar = (Pane)root.lookup("#titleBar");

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        WindowUtils.moveWindow(stage, titlebar);

        Scene scene = new Scene(root);

        if (styleFile != null && !styleFile.isEmpty()) {
            String cssUrl = getClass().getResource(styleFile).toExternalForm();
            scene.getStylesheets().add(cssUrl);
        }
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(true);
        stage.setScene(scene);

        stage.show();
    }

}