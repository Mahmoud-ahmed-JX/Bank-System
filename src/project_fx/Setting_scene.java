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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Setting_scene {

    public static void init(Stage stage) throws SQLException {

        String name_of_user = Db_func.getName().split(" ")[0];

        Text title = new Text("Hello," + name_of_user);
        Text title2 = new Text("Hello," + name_of_user);
        title.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 24));
        title2.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 18));

        Label Change_password = new Label("Change Password");
        Label Change_number = new Label("Change Number");
        Label about_us = new Label("About Us");
        Label back=new Label("back");
        Button btn_conifirm_num = new Button("Confirm");
        Button btn_conifirm_pass = new Button("Confirm");
        Change_password.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 15));
        Change_number.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 15));
        about_us.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 15));
        back.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 15));
//            title.setFont(Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 24));

        Label old_num = new Label("Old Number:");
        Label old_pass = new Label("Old Passowrd:");
        Label new_num = new Label("New Number:");
        Label new_pass = new Label("New Password:");

        TextField old_num_textfield = new TextField();
        TextField old_pass_textfield = new TextField();
        TextField new_num_textfield = new TextField();
        TextField new_pass_textfield = new TextField();

        Line line = new Line(233.333, 0, 233.3333, 500);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2);

        
       
//                       
        GridPane root = new GridPane();
        GridPane root1 = new GridPane();

        DropShadow shadow = new DropShadow(10, 5, 5, Color.BLACK);
        DropShadow shadow1 = new DropShadow(0, 0, 0, Color.TRANSPARENT);

        HBox H;
        Change_password.setOnMouseClicked((event) -> {
            Change_number.setBackground(Background.EMPTY);

            Change_number.setBorder(Border.EMPTY);
            root.getChildren().clear();
            root.add(old_pass, 0, 0);
            root.add(old_pass_textfield, 1, 0);
            root.add(new_pass, 0, 1);
            root.add(new_pass_textfield, 1, 1);
            root.add(btn_conifirm_pass, 0, 2);
            root.setVgap(10);
            root.setHgap(10);
            root.setAlignment(Pos.CENTER_RIGHT);
            root.setPadding(new Insets(90));

            Change_password.setStyle("-fx-padding: 3;");

            Change_password.setBorder(new Border(new BorderStroke(
                    Color.BLACK, // Border color
                    BorderStrokeStyle.SOLID, // Border style
                    new CornerRadii(10), // Corner radius (10px rounded corners)
                    new BorderWidths(1)
            )));
            Change_password.setBackground(new Background(new BackgroundFill(
                    Color.LIGHTBLUE, // Background color
                    new CornerRadii(10), // Corner radius to match the border
                    null // Insets (null for no margin inside the background)
            )));

            // Apply the shadow to the label
            Change_password.setEffect(shadow);
            Change_number.setEffect(shadow1);

        });

        Change_number.setOnMouseClicked((event) -> {
            Change_password.setBackground(Background.EMPTY);

            Change_password.setBorder(Border.EMPTY);

            root.getChildren().clear();

            root.add(old_num, 0, 0);
            root.add(old_num_textfield, 1, 0);
            root.add(new_num, 0, 1);
            root.add(new_num_textfield, 1, 1);
            root.add(btn_conifirm_num, 0, 2);
            root.setVgap(10);
            root.setHgap(10);
            root.setAlignment(Pos.CENTER_RIGHT);
            root.setPadding(new Insets(90));

            Change_number.setStyle("-fx-padding: 3;");
            
            
            
            Change_number.setBorder(new Border(new BorderStroke(
                    Color.BLACK, // Border color
                    BorderStrokeStyle.SOLID, // Border style
                    new CornerRadii(10), // Corner radius (10px rounded corners)
                    new BorderWidths(1)
            )));
            Change_number.setBackground(new Background(new BackgroundFill(
                    Color.LIGHTBLUE, // Background color
                    new CornerRadii(10), // Corner radius to match the border
                    null // Insets (null for no margin inside the background)
            )));

            Change_number.setEffect(shadow);
            Change_password.setEffect(shadow1);

        });
        
        btn_conifirm_pass.setOnAction((t) -> {
            try {
                if(Db_func.getPass().equals(old_pass_textfield.getText())){
                    Db_func.change_pass(new_pass_textfield.getText());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Setting_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_conifirm_pass.setOnMouseMoved((event) -> {
            btn_conifirm_pass.setEffect(shadow);
        });
        btn_conifirm_pass.setOnMouseExited((event) -> {
            btn_conifirm_pass.setEffect(shadow1);
        });
        
        
        
        btn_conifirm_num.setOnAction((t) -> {
        
            try {
                if(Db_func.getNumber().equals(old_num_textfield.getText())){
                    Db_func.change_num(new_num_textfield.getText());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Setting_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        
        
        btn_conifirm_num.setOnMouseMoved((event) -> {
            btn_conifirm_num.setEffect(shadow);
        });
        btn_conifirm_num.setOnMouseExited((event) -> {
            btn_conifirm_num.setEffect(shadow1);
        });
        
        back.setOnMouseClicked((t) -> {
           customers_scene.init(stage);
        });
        
        VBox vv = new VBox(title);
        vv.setSpacing(50);
        vv.setAlignment(Pos.TOP_LEFT);
        vv.setMargin(title, new Insets(20, 20, 20, 20));

        VBox v = new VBox(Change_number, Change_password, about_us,back, line);
        v.setSpacing(50);
        v.setAlignment(Pos.CENTER_LEFT);
//           v.setMargin(title,  new Insets(0, 0, 0, 0));
        v.setMargin(Change_number, new Insets(0, 20, 0, 20));
        v.setMargin(Change_password, new Insets(0, 20, 0, 20));
        v.setMargin(about_us, new Insets(0, 20, 0, 20));
        v.setMargin(back, new Insets(0, 20, 0, 20));
//          ------------------------------------------------
        VBox vvv = new VBox(vv, v);
        vvv.setSpacing(90);

//--------------------------------------------
        HBox h = new HBox(vvv, line, root);
        h.setSpacing(10);
        h.setAlignment(Pos.CENTER_LEFT);
//           h.setMargin(title,  new Insets(80));
//           h.spacingProperty(title.s);
        h.setMargin(Change_number, new Insets(80));
        h.setMargin(Change_password, new Insets(80));
        h.setMargin(about_us, new Insets(80));

//         root.add(new_num, 0, 0);
//           root.add(new_num_textfield, 1, 0);
        Scene scene = new Scene(h, 700, 500);
        scene.getStylesheets().add(Setting_scene.class.getResource("style.css").toExternalForm()); 
        stage.setScene(scene);
        stage.setTitle("Setting");
        stage.show();
    }
}
