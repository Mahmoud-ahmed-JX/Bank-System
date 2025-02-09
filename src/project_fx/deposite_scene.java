/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mega Store
 */
public class deposite_scene {
    
    public static void init(Stage stage){
  
        // Deposit action
        
            Label amountLabel = new Label("Enter Deposit Amount:");
            TextField amountField = new TextField();
            amountField.setPromptText("Deposit Amount");

            Button submitButton = new Button("Submit");
            Button backButton = new Button("Back");

            // Style
            amountField.setStyle("-fx-font-size: 16px;");
            amountLabel.setStyle("-fx-font-size: 16px;");
            submitButton.setStyle("-fx-font-size: 16px;");
            backButton.setStyle("-fx-font-size: 16px;");

            HBox buttonBox = new HBox(20, submitButton, backButton);
            buttonBox.setAlignment(Pos.CENTER);

            VBox depositLayout = new VBox(20, amountLabel, amountField, buttonBox);
            depositLayout.setAlignment(Pos.CENTER);
            depositLayout.setPadding(new Insets(20));

            Scene Scene = new Scene(depositLayout, 500, 400);

            // Submit button action
            submitButton.setOnAction(submitEvent -> {
                String depositAmount = amountField.getText();

                if (depositAmount.isEmpty()) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a deposit amount!");
                    alert.showAndWait();
                } else {
                    try {
                        Db_func.deposite(Integer.parseInt(depositAmount));
                        Label confirmationLabel = new Label(
                        "Deposit Successful!\n\n" +
                        "Deposit Amount: $" + depositAmount
                    );
                    confirmationLabel.setStyle("-fx-font-size: 18px;");

                    Button backToMainButton = new Button("Back to Main");
                    backToMainButton.setStyle("-fx-font-size: 16px;");

                    VBox confirmationLayout = new VBox(20, confirmationLabel, backToMainButton);
                    confirmationLayout.setAlignment(Pos.CENTER);
                    confirmationLayout.setPadding(new Insets(20));

                    Scene confirmationScene = new Scene(confirmationLayout, 500, 400);
                    stage.setScene(confirmationScene);
                    stage.show();
                    backToMainButton.setOnAction((s) -> {
                        customers_scene.init(stage);
                    });
                    } catch (SQLException ex) {
                        Logger.getLogger(deposite_scene.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   
                }
                
            });

            backButton.setOnAction((t) -> {
                customers_scene.init(stage);
            });
            Scene.getStylesheets().add(deposite_scene.class.getResource("style.css").toExternalForm()); 
            stage.setScene(Scene);
            stage.setTitle("Deposite");
            stage.show();
    }

       
    
}
