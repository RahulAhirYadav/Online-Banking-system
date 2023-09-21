/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rahul
 */
public class DepoDAO {
    private String accountnumber;
   
     private int amount;
    

    Connection con;
    Statement s;
    ResultSet rs;

    PreparedStatement st;
    


   public DepoDAO(){
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

   public int UpdateRecord(String accno,int amount){
       int result=0;
       int balance;
       try{
         String  SelectQuery="select balance from account where accountnumber=?";
         st= (PreparedStatement) con.prepareStatement(SelectQuery);
         st.setString(1,accno);
         rs=st.executeQuery();

      if(rs.next()){
          balance=rs.getInt("balance");

         if(balance>=0){
         
             st=(PreparedStatement) con.prepareStatement("update account set balance=? where accountnumber=?");
             st.setInt(1, balance+amount);
             st.setString(2, accno);
             result=st.executeUpdate();
         }
       }
       }
       catch(Exception e){
           System.out.println(e);

      }
       return result;
      }

       }

    
      
     
     
  
