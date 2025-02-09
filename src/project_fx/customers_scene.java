/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

/**
 *
 * @author Mega Store
 */

import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class customers_scene {
    
    public static void init(Stage stage){
        
        Label sign_out=new Label("sign out");
        // Create buttons
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button checkBalanceButton = new Button("Check Balance");
        Button settingsButton = new Button("Settings");
//        Button showDetailsButton = new Button("Show Details");

        // Style buttons
        depositButton.setStyle("-fx-font-size: 16px;");
        withdrawButton.setStyle("-fx-font-size: 16px;");
        checkBalanceButton.setStyle("-fx-font-size: 16px;");
        settingsButton.setStyle("-fx-font-size: 16px;");
//        showDetailsButton.setStyle("-fx-font-size: 16px;");
        depositButton.setPrefSize(150, 60);
        withdrawButton.setPrefSize(150, 60);
        checkBalanceButton.setPrefSize(150, 60);
        settingsButton.setPrefSize(150, 60);
//        showDetailsButton.setPrefSize(200, 70);

        // Arrange buttons in a grid
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(depositButton, 1, 4);
        gridPane.add(withdrawButton, 2, 4);
        gridPane.add(checkBalanceButton, 1, 5);
        gridPane.add(settingsButton, 2, 5);
        gridPane.add(sign_out, 0, 10);
            
        depositButton.setOnAction((t) -> {
            deposite_scene.init(stage);
        });
        
        settingsButton.setOnAction((f) -> {
            try {
                Setting_scene.init(stage);
            } catch (SQLException ex) {
                Logger.getLogger(customers_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        sign_out.setOnMouseClicked((t) -> {
        
            log_in_scene.init(stage);
        });
        
         Scene mainScene = new Scene(gridPane, 500, 400);
        checkBalanceButton.setOnAction((t) -> {
            try {
                check_balance_scene.init(stage);
            } catch (SQLException ex) {
                Logger.getLogger(customers_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
           
        });
        
        withdrawButton.setOnAction((f) -> {
                try {
                    withdraw_scene.init(stage);
                } catch (SQLException ex) {
                    Logger.getLogger(customers_scene.class.getName()).log(Level.SEVERE, null, ex);
                }
        });

       
//        mainLayout.setAlignment(Pos.CENTER);
//        mainLayout.setPadding(new Insets(20));
        mainScene.getStylesheets().add(customers_scene.class.getResource("style.css").toExternalForm()); 
        stage.setScene(mainScene);
        stage.setTitle("Bank System");
        stage.show();
}
}
