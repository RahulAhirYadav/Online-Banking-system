/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rahul
 */
public class newAccountDAO {
    private String name;
    private String accountnumber;
    private int balance;
  

     Connection con;
    Statement s;
    ResultSet rs;

    PreparedStatement ps;


   public newAccountDAO(){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","admin","");
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }

        }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  


   

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

  

   public int newaccount( String accountnumber,int balance,String name){
       int result=0;

       try{



           ps= con.prepareStatement( "update account set accountnumber=?,balance=? where name=?");
      
         ps.setString(1, accountnumber);
        ps.setInt(2, balance);
        ps.setString(3,name);
      
      
     result = ps.executeUpdate();


       


           

       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
       return result;
   }
 
   }





