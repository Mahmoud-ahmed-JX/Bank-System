/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

import javafx.stage.Stage;

/**
 *
 * @author Mega Store
 */

import java.awt.Image;
import java.sql.SQLException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class manager_scene {
    
    private static TableView<Customers> t;
    
    public static void init(Stage stage) throws SQLException{
        try {
            // search gridpane
            Label searchL=new Label("search for customer");
            searchL.getStyleClass().add("title");
            Label acc_numL=new Label("enter account number");
            TextField acc_num=new TextField();
            Button search_btn=new Button("search");
            Button clear_btn=new Button("Refresh");
            GridPane search_g=new GridPane(10,10);
            search_g.add(searchL, 0, 0,2,1);
            search_g.add(acc_numL, 0, 1);
            search_g.add(acc_num, 1, 1);
            search_g.add(search_btn, 0, 2);
            search_g.add(clear_btn, 1, 2);
            search_g.setAlignment(Pos.CENTER);
            search_g.setPadding(new Insets(20,20,20,20));
            

            //delete gridpane
            Label deleteL=new Label("delete customer");
            deleteL.getStyleClass().add("title");
            Label acc_numL2=new Label("enter account number");
            TextField acc_num2=new TextField();
            Button delete_btn=new Button("delete");
            GridPane delete_g=new GridPane(10,10);
            delete_g.add(deleteL, 0, 0,2,1);
            delete_g.add(acc_numL2, 0, 1);
            delete_g.add(acc_num2, 1, 1);
            delete_g.add(delete_btn, 1, 2);
            delete_g.setAlignment(Pos.CENTER);
            delete_g.setPadding(new Insets(20,20,20,20));
            //container grid
            VBox v=new VBox(100,search_g,delete_g);
            v.setAlignment(Pos.CENTER);
            
            //table
            t=new TableView<>();
            TableColumn<Customers,Integer>c1=new TableColumn<>("Account num");
            c1.setMinWidth(100);
            c1.setCellValueFactory(new PropertyValueFactory("account_num"));
            
            TableColumn<Customers,String>c2=new TableColumn<>("name");
            c2.setMinWidth(100);
            c2.setCellValueFactory(new PropertyValueFactory("name"));
            
            TableColumn<Customers,String>c3=new TableColumn<>("City");
            c3.setMinWidth(100);
            c3.setCellValueFactory(new PropertyValueFactory("city"));
            
            TableColumn<Customers,String>c4=new TableColumn<>("Password");
            c4.setMinWidth(100);
            c4.setCellValueFactory(new PropertyValueFactory("pass"));
            
            TableColumn<Customers,Character>c5=new TableColumn<>("Sex");
            c5.setMinWidth(100);
            c5.setCellValueFactory(new PropertyValueFactory("sex"));
            
            TableColumn<Customers,String>c6=new TableColumn<>("Phone");
            c6.setMinWidth(100);
            c6.setCellValueFactory(new PropertyValueFactory("phone_num"));
            
            TableColumn<Customers,Integer>c7=new TableColumn<>("Age");
            c7.setMinWidth(100);
            c7.setCellValueFactory(new PropertyValueFactory("age"));
            
            TableColumn<Customers,Integer>c8=new TableColumn<>("Balance");
            c8.setMinWidth(100);
            c8.setCellValueFactory(new PropertyValueFactory("balance"));
            
            t.getColumns().addAll(c1,c2,c3,c4,c5,c6,c7,c8);
            
            Db_func.show(t);
            
            search_btn.setOnAction((c) -> {
                try {
                    Db_func.update_search(Integer.parseInt(acc_num.getText()), t);
                } catch (SQLException ex) {
                    Logger.getLogger(manager_scene.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            clear_btn.setOnAction((x) -> {
                acc_num.clear();
                try {
                    Db_func.show(t);
                } catch (SQLException ex) {
                    Logger.getLogger(manager_scene.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            delete_btn.setOnAction((d) -> {
                
                try {
                    Db_func.update_delete(acc_num2.getText());
                    Db_func.show(t);
                } catch (SQLException ex) {
                    Logger.getLogger(manager_scene.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
           
            
            
            FlowPane f=new FlowPane(v,t);
            f.setAlignment(Pos.CENTER);
            
            Scene scene=new Scene(f,1000,700);
            scene.getStylesheets().add(manager_scene.class.getResource("style.css").toExternalForm()); 
            stage.setScene(scene);
            stage.setTitle("Batlmis");
            stage.show();
        } catch (SQLException ex) {
            Logger.getLogger(manager_scene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
