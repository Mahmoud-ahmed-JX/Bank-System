/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  project_fx;

/**
 *
 * @author Mega Store
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class regist_scene {
    public static void init(Stage stage){



        // Register Scene
        GridPane g2 = new GridPane();
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        Label phoneNumberLabel = new Label("Phone Number");
        TextField phoneNumberField = new TextField();
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        ToggleGroup genderToggleButton = new ToggleGroup();
        maleRadioButton.setSelected(true);
        Label ageLabel = new Label("Age");
        TextField ageField = new TextField();
        Label cityLabel = new Label("City");
        TextField cityField = new TextField();
        Label passwordLabelRegister = new Label("Password");
        PasswordField passwordFieldRegister = new PasswordField();
        Label confirmPasswordLabel = new Label("Confirms Password");
        PasswordField confirmPasswordField = new PasswordField();
        CheckBox terms = new CheckBox("I agree to the terms and conditions");
        Button backButton = new Button("Back");
        Button signupButton = new Button("Register");
        genderToggleButton.getToggles().addAll(maleRadioButton,femaleRadioButton);
        g2.add(nameLabel,0,0);
        g2.add(nameField,1,0);
        g2.add(phoneNumberLabel,0,1);
        g2.add(phoneNumberField,1,1);
        g2.add(maleRadioButton,0,2);
        g2.add(femaleRadioButton,1,2);
        g2.add(ageLabel,0,3);
        g2.add(ageField,1,3);
        g2.add(cityLabel,0,4);
        g2.add(cityField,1,4);
        g2.add(passwordLabelRegister,0,5);
        g2.add(passwordFieldRegister,1,5);
        g2.add(confirmPasswordLabel,0,6);
        g2.add(confirmPasswordField,1,6);
        g2.add(terms,0,7,2,1);
        g2.add(backButton,0,8);
        g2.add(signupButton,1,8);
        g2.setHgap(10);
        g2.setVgap(10);
        g2.setAlignment(Pos.CENTER);
        Scene s2 = new Scene(g2,700,600);
        /////
        // Buttons Actions


        backButton.setOnAction(e->{
            log_in_scene.init(stage);
//            stage.show();

        });
        signupButton.setOnAction(e-> {
            if (!terms.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Terms and Conditions");
                alert.setHeaderText(null);
                alert.setContentText("You must agree the terms and conditions to register ");
                alert.showAndWait();

            } else {
                if (nameField.getText().isEmpty() | phoneNumberField.getText().isEmpty() | ageField.getText().isEmpty() | cityField.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(" Fill The Empty Fields ");
                    alert.showAndWait();
                } else if (passwordFieldRegister.getText().length() < 8) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Password must be more than 8 characters");
                    alert.showAndWait();
                } else {
                    if (!passwordFieldRegister.getText().equals(confirmPasswordField.getText())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Password must be the same");
                        alert.showAndWait();
                    } else {


                        String acc;


                        String s;
                        if (maleRadioButton.isSelected()) {
                            s = "M";
                        } else {
                            s = "F";
                        }
                        try {
                            Db_func.insert_db(nameField.getText(), phoneNumberField.getText(), s, Integer.parseInt(ageField.getText()), cityField.getText(), passwordFieldRegister.getText());
                        } catch (SQLException ex) {
                            Logger.getLogger(regist_scene.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            acc = Db_func.acc_num_reg();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Registration Successful");
                            alert.setHeaderText(null);
                            alert.setContentText("You have successfully registered "
                                    + "your account number is: " + acc);
                            alert.showAndWait();
                        } catch (SQLException ex) {
                            Logger.getLogger(regist_scene.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        log_in_scene.init(stage);
                    }
                }
            }

        });
        s2.getStylesheets().add(regist_scene.class.getResource("style.css").toExternalForm());
        stage.setScene(s2);
        stage.setTitle("Regist");
        stage.show();
        }
    
      
}