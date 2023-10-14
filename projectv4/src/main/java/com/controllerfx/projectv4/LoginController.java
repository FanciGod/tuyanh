package com.controllerfx.projectv4;

import JDBCConnect.model.LoginModel;
import entity.GetData;
import entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    LoginModel loginModel;

    public void AdminLogin() {
        loginModel = new LoginModel();
        User user = loginModel.addminLogin(username.getText(), password.getText());
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!!!!");
            alert.setContentText("fill the blank....");
            alert.setHeaderText(null);
            alert.show();
        } else {
            if (user != null) {
                GetData.name = user.getName();
                GetData.password = user.getPassword();
                GetData.username = user.getUsername();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMATION!!");
                alert.setContentText("Login successfully");
                alert.showAndWait();
                btnLogin.getScene().getWindow().hide();
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/Dashboard.css")).toExternalForm());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR!!!!");
                alert.setContentText("Wrong username/password");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
    }
}

