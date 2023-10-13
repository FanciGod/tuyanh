package com.controllerfx.projectv4;

import JDBCConnect.Connect.JDBCConnect;
import javafx.event.ActionEvent;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;


    public void AdminLogin() {
        String sql = "SELECT * FROM projectv4.account WHERE `Account_name` = ? and `Password` = ? ";
        Connection con = JDBCConnect.Connect();
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            PS.setString(1, username.getText());
            PS.setString(2, password.getText());
            ResultSet rs = PS.executeQuery();
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR!!!!");
                alert.setContentText("fill the blank....");
                alert.setHeaderText(null);
                alert.show();
            } else {
                if (rs.next() == true) {
                    String Account_name = rs.getString("Account_name");
                    GetData.name = Account_name;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("INFORMATION!!");
                    alert.setContentText("Login successfully");
                    alert.showAndWait();
                    btnLogin.getScene().getWindow().hide();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.showAndWait();
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

