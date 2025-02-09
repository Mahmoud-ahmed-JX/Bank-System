/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Mega Store
 */
public class log_in_scene {

    public static void init(Stage stage) {
        GridPane g1 = new GridPane();
        g1.setStyle(
                " -fx-background-color: radial-gradient(center 50% 50%,radius 50%,#9CCDDB,#5790AB);");


        Label accountNumberLabel = new Label("Account Number ");
        Label passwordLabel = new Label("Password");
        Label noAccountLabel = new Label("Create new account ");



        TextField accountField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        loginButton.getStyleClass().add("button");
        registerButton.getStyleClass().add("button");

        registerButton.setOnAction(e -> {
            regist_scene.init(stage);
            stage.show();
        });

        loginButton.setOnAction((t) -> {

            try {
                if (accountField.getText().isEmpty() | passwordField.getText().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Fill all fields");
                    a.show();
                } else {
                    if (Db_func.check_login(Integer.parseInt(accountField.getText()), passwordField.getText())) {
                        Db_func.setAcc_num(Integer.parseInt(accountField.getText()));
                        Db_func.setPass(passwordField.getText());
                        customers_scene.init(stage);
                    } else if (Integer.parseInt(accountField.getText()) == (Manager.acc_num) && passwordField.getText().equals(Manager.password)) {
                        manager_scene.init(stage);
                    } else {
                        Alert a = new Alert(Alert.AlertType.ERROR, "Wrong number or password");
                        a.show();
                        accountField.clear();
                        passwordField.clear();
                    }
                }
//            else if(){}
            } catch (SQLException ex) {
                Logger.getLogger(log_in_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        g1.add(accountNumberLabel, 0, 0);
        g1.add(accountField, 1, 0);
        g1.add(passwordLabel, 0, 1);
        g1.add(passwordField, 1, 1);
        g1.add(loginButton, 1, 2, 2, 1);
        g1.add(noAccountLabel, 0, 3);
        g1.add(registerButton, 1, 3);
        g1.setVgap(10);
        g1.setHgap(10);
        g1.setAlignment(Pos.CENTER);
        Scene s1 = new Scene(g1, 700, 600);

        s1.getStylesheets().add(log_in_scene.class.getResource("style.css").toExternalForm());
        stage.setScene(s1);
        stage.setTitle("Log in");
        stage.show();
    }

}
