/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_fx;

import java.sql.*;

/**
 *
 * @author Mega Store
 */
public class Dbconnection {
        public static Connection dbcon(){ 
                     Connection con= null;

         try{
             con= DriverManager.getConnection("jdbc:oracle:thin:project_fx/123@localhost:1521/XE"); 
             System.out.println("Succses");
        }catch(Exception ex){
            System.out.println(ex);
        }
         return con;
        }
        
        public void test(){}
        
}
