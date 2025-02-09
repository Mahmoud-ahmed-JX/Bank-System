/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

/**
 *
 * @author Mega Store
 */
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Db_func {
    private static Connection con=null;
    private static ResultSet res=null;
    private static PreparedStatement pst=null;
    private static ObservableList<Customers> data;
    
    
    private static int acc_num;
    private static String pass;
    private static String number;
    private static String name;

    public static int getAcc_num() throws SQLException {
        
        return acc_num;
    }

    public static void setAcc_num(int acc_num) {
        Db_func.acc_num = acc_num;
    }

    public static String getPass() throws SQLException {
        con=Dbconnection.dbcon();
        String sql="select password from customers where acc_num=?";
        pst=con.prepareStatement(sql);
        pst.setInt(1, acc_num);
        res=pst.executeQuery();
        res.next();
        String pas=res.getString(1);
        pst.close();
        con.close();
        return pas;
    }

    public static void setPass(String pass) {
        Db_func.pass = pass;
    }
    
    public static String getNumber() throws SQLException {
        con=Dbconnection.dbcon();
        String sql="select phone_num from customers where acc_num=?";
        pst=con.prepareStatement(sql);
        pst.setInt(1, acc_num);
        res=pst.executeQuery();
        res.next();
        String phone_num= res.getString(1);
        pst.close();
        con.close();
        return phone_num;
    }
    public static String getName() throws SQLException {
        con=Dbconnection.dbcon();
        String sql="select name from customers where acc_num=?";
        pst=con.prepareStatement(sql);
        pst.setInt(1, acc_num);
        res=pst.executeQuery();
        res.next();
        String Name= res.getString(1);
        pst.close();
        con.close();
        return Name;
    }
    
    
    public static void show(TableView t) throws SQLException{
        data=FXCollections.observableArrayList();
        con=Dbconnection.dbcon();
        pst=con.prepareStatement("select * from customers");
        res=pst.executeQuery();
    
        while(res.next()){
          Customers c= new Customers(res.getString(2),res.getString(3),res.getString(4),res.getString(5).charAt(0),res.getString(6),res.getInt(7));
          c.setAccount_num(res.getInt(1));
          c.setBalance(res.getInt(8));
          data.add(c);
        }
        pst.close();
        con.close();
        t.setItems(data);
    }
    
    public static void insert_db(String name,String phone_num,String sex,int age,String city,String password) throws SQLException{
     con=Dbconnection.dbcon();
     String sql="insert into customers(name,city,password,sex,phone_num,age) values(?,?,?,?,?,?)";
     pst=con.prepareStatement(sql);
     pst.setString(1, name);
     pst.setString(2, city);
     pst.setString(3, password);
     pst.setString(4, sex);
     pst.setString(5, phone_num);
     pst.setInt(6, age);
     
     int i=pst.executeUpdate();
     
     if(i==1)
            System.out.println("Inserted succesfuly");
     pst.close();
     con.close();
    }
    
    public static void update_delete(String acc_num) throws SQLException{
     con=Dbconnection.dbcon();
     String sql="delete from customers where acc_num=?";
     pst=con.prepareStatement(sql);
     pst.setString(1, acc_num);
     int i=pst.executeUpdate();
     if(i==1)
            System.out.println("customer deleted successfuly");
     pst.close();
     con.close();
       
    }
    public static void update_search(int acc_num,TableView t) throws SQLException{
     con=Dbconnection.dbcon();
     data=FXCollections.observableArrayList();
        con=Dbconnection.dbcon();
        pst=con.prepareStatement("select * from customers where acc_num=?");
        pst.setInt(1, acc_num);
        res=pst.executeQuery();
    
        if(res.next()){
          Customers c= new Customers(res.getString(2),res.getString(3),res.getString(4),res.getString(5).charAt(0),res.getString(6),res.getInt(7));
          c.setAccount_num(res.getInt(1));
          c.setBalance(res.getInt(8));
          data.add(c);
        }
        else{
//            t.setPlaceholder();
        }
        pst.close();
        con.close();
        t.setItems(data);
       
    }
    
    public static boolean check_login(int acc_num,String pass) throws SQLException{
        con=Dbconnection.dbcon();
     
        con=Dbconnection.dbcon();
        pst=con.prepareStatement("select * from customers where acc_num=? and password=?");
        pst.setInt(1, acc_num);
        pst.setString(2, pass);
        res=pst.executeQuery();
    
        if(res.next()){
            System.out.println("you have been log in successfuly");
             pst.close();
             con.close();
            return true;
        }
        else{
//            t.setPlaceholder();
             pst.close();
            con.close();
            return false;
        }
    }
    public static String acc_num_reg() throws SQLException{
        con=Dbconnection.dbcon();
        
        con=Dbconnection.dbcon();
        pst=con.prepareStatement("select max(acc_num) from customers");
        res=pst.executeQuery();
        res.next();
        String s=res.getString(1);
        
    
      

            pst.close();
            con.close();
            
        
       
            return s;
    }
    
    public static int check_balance() throws SQLException{
     con=Dbconnection.dbcon();
     String sql="select balance from customers where acc_num=?";
     pst=con.prepareStatement(sql);
     pst.setInt(1, acc_num);
     res=pst.executeQuery();
     res.next();
     int balance= res.getInt(1);
     pst.close();
     con.close();
     return balance;
    }
    
    public static void deposite(int deposite_amount) throws SQLException{
    int balance=check_balance();
    con=Dbconnection.dbcon();
    String sql="update customers set balance=? where acc_num=?";
    pst=con.prepareStatement(sql);
    pst.setInt(1, deposite_amount+balance);
    pst.setInt(2, acc_num);
    pst.executeUpdate();
    pst.close();
    con.close();
    }
    
    public static void withdraw(int withdraw_amount) throws SQLException{
    int balance=check_balance();
    con=Dbconnection.dbcon();
    String sql="update customers set balance=? where acc_num=?";
    pst=con.prepareStatement(sql);
    pst.setInt(1, balance-withdraw_amount);
    pst.setInt(2, acc_num);
    pst.executeUpdate();
    pst.close();
    con.close();
    }
    
    public static void change_pass(String password) throws SQLException{
    
    con=Dbconnection.dbcon();
    String sql="update customers set password=? where acc_num=?";
    pst=con.prepareStatement(sql);
    pst.setString(1, password);
    pst.setInt(2, acc_num);
    pst.executeUpdate();
    pst.close();
    con.close();
    }
    public static void change_num(String phone_num) throws SQLException{
    
    con=Dbconnection.dbcon();
    String sql="update customers set phone_num=? where acc_num=?";
    pst=con.prepareStatement(sql);
    pst.setString(1, phone_num);
    pst.setInt(2, acc_num);
    pst.executeUpdate();
    pst.close();
    con.close();
    }
    
    
    
}
