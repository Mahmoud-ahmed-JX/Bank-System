/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Mega Store
 */
public class check_balance_scene {
    
    public static void init(Stage stage) throws SQLException{
         Label balanceL=new Label("your balance is:  ");
           Label relBalance=new Label("?");
           Button back_button=new Button("back");
           GridPane g=new GridPane(30,30);
           g.add(balanceL, 0, 0);
           g.add(relBalance, 1, 0);
           g.add(back_button, 0, 1);
           g.setAlignment(Pos.CENTER);
           back_button.setOnAction((f) -> {
              customers_scene.init(stage);
           });
           relBalance.setText(Integer.toString(Db_func.check_balance()));
           
           Scene balScene=new Scene(g,500,500);
           balScene.getStylesheets().add(check_balance_scene.class.getResource("style.css").toExternalForm()); 
           stage.setTitle("check balance");
           stage.setScene(balScene);
           
    }
}
