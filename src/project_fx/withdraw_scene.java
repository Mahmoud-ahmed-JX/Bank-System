/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

/**
 *
 * @author Mega Store
 */
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class withdraw_scene {

    static Alert a1;
    static Alert a2;
    static Alert a3;
    

    public static void init(Stage stage) throws SQLException {
        int balance = Db_func.check_balance();
        Label Header = new Label("Select the Value:");
        Button w_50 = new Button("     50      ");
        Button w_100 = new Button("     100     ");
        Button w_200 = new Button("     200     ");
        Button w_500 = new Button("     500      ");
        Button w_1000 = new Button("    1000    ");
        Button w_1500 = new Button("    1500    ");
        Button w_2000 = new Button("    2000    ");
        Button w_0 = new Button("    Other   ");
        Button Back = new Button("Back");
        GridPane root = new GridPane(30, 30);
        root.add(Header, 0, 0, 3, 1);
        root.add(w_50, 0, 1);
        root.add(w_200, 0, 2);
        root.add(w_1000, 0, 3);
        root.add(w_2000, 0, 4);
        root.add(w_100, 2, 1);
        root.add(w_500, 2, 2);
        root.add(w_1500, 2, 3);
        root.add(w_0, 2, 4);
        root.add(Back, 0, 5);
        root.setAlignment(Pos.CENTER);

        Scene s = new Scene(root, 700, 500);

//_______________________________________________________________________________________________________________________        
       

//_____________________________________________________________________________________________________________________________
        a1 = new Alert(Alert.AlertType.INFORMATION, "Successful");

        a1.setTitle("Successful");
        a1.setHeaderText(null);
        a1.setContentText("Withdrawal successful!");
        a1.setOnCloseRequest(event1 -> {
            stage.setScene(s);
            stage.show();
        });

        a2 = new Alert(Alert.AlertType.ERROR);

        a2.setTitle(" Error");
        a2.setContentText("Error in the withdrawal process");
        a2.setOnCloseRequest(event1 -> {
            
        });

        a3 = new Alert(Alert.AlertType.CONFIRMATION);
        a3.setTitle("massege");
        a3.setContentText("Do you want to continue?");
        ButtonType Yes = ButtonType.YES;
        ButtonType No = ButtonType.NO;

        a3.getButtonTypes().setAll(Yes, No);

//_______________________________________________________________________
        w_50.setOnAction(e -> {
            try {
                Withdraw(50);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        w_100.setOnAction(e -> {
            try {
                Withdraw(100);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        w_200.setOnAction(e -> {
            try {
                Withdraw(200);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        w_500.setOnAction(e -> {
            try {
                Withdraw(500);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        w_1000.setOnAction(e -> {
            try {
                Withdraw(1000);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        w_1500.setOnAction(e -> {
            try {
                Withdraw(1500);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        w_2000.setOnAction(e -> {
            try {
                Withdraw(2000);
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//            
        w_0.setOnAction(e -> {
         //second scene
        Label Value = new Label("Take the Value");
        TextField ValueT = new TextField();
        Button Submit = new Button("Submit");
        Button Back2 = new Button("Back");
        Label balanc = null;
            try {
                balanc = new Label("Your Balance is :" + Db_func.check_balance());
            } catch (SQLException ex) {
                Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
            }

        GridPane root1 = new GridPane(30, 30);
        root1.add(Value, 0, 0);
        root1.add(ValueT, 1, 0);
        root1.add(balanc, 1, 1);
        root1.add(Back2, 1, 2);
        root1.add(Submit, 0, 2);
        root1.setAlignment(Pos.CENTER);

        
            
        Back2.setOnAction(f -> {
                
                stage.setScene(s);
            });
            
            Submit.setOnAction(x -> {

            if (ValueT.getText().equals("") || ValueT.getText().equals("0")) {
                a2.show();
            } else {
                if (balance >= parseInt(ValueT.getText())& balance>0) {
                    try {
                        Withdraw(parseInt(ValueT.getText()));
                        a1.show();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(withdraw_scene.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    a2.show();
                }
            }

        });
            
            Scene s1 = new Scene(root1, 700, 500);
            s1.getStylesheets().add(withdraw_scene.class.getResource("style.css").toExternalForm()); 
            stage.setScene(s1);
            stage.show();
        });

        
        Back.setOnAction(e -> {
            customers_scene.init(stage);
        });

// _______________________________________________________________________________________________________________
        s.getStylesheets().add(withdraw_scene.class.getResource("style.css").toExternalForm()); 
        stage.setScene(s);
        stage.show();
    }

    public static void Withdraw(int amount) throws SQLException {
        int balance = Db_func.check_balance();
        Optional<ButtonType> result = a3.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            if (balance >= amount) {
                balance -= amount;
                Db_func.withdraw(amount);
                a1.setContentText("Withdrawal successful! Your new balance is: " + balance);
                a1.show();

            } else {

                a2.setContentText("Insufficient balance! Your current balance is: " + balance);
                a2.show();
            }
        }
    }
}
