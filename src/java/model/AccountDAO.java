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
public class AccountDAO {
    private String  name;
   
     private String number;
     private String addarnumber;
     private String accountnumbner;

      
    private String password;
 private int balance;
    

    Connection con;
    Statement s;
    ResultSet rs;

    PreparedStatement st;


   public AccountDAO(){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","admin","");
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }

        }

   
    public String getAddarnumber() {
        return addarnumber;
    }

    public void setAddarnumber(String addarnumber) {
        this.addarnumber = addarnumber;
    }

    public String getAccountnumbner() {
        return accountnumbner;
    }

    public void setAccountnumbner(String accountnumbner) {
        this.accountnumbner = accountnumbner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

  

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    


    public int insertRecord()
    {
       int result=0;
        try{
            st =con.prepareStatement(" insert into account values(?,?,?,?,?,?)");
            st.setString(1,name);
            
             st.setString(2,number);
             st.setString(3,addarnumber);
             st.setString(4," ");
             st.setString(5, password);
             st.setInt(6,0);



            result=st.executeUpdate();
           

        }
        catch(Exception ex){
            System.out.println(ex);

        }
        return result;


    }


    }





