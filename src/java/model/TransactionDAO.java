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
public class TransactionDAO {
    private String AccountNumber;
    private int amount;

    Connection con;
    Statement s;
    ResultSet rs;
    PreparedStatement st;



  public  TransactionDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","admin","");
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }

        }


    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


public int processTransaction(String acno,int amount){
    int result=0;
    int balance=0;
    boolean b=false;
    try
    {
    
        String selectQuery = "SELECT balance FROM account WHERE accountnumber=?";
            st=con.prepareStatement(selectQuery);
            st.setString(1, acno);
             rs = st.executeQuery();
if(rs.next()) {
                 balance = rs.getInt("balance");
              
}
                if (balance >= amount)
                {
      st=con.prepareStatement("update account set balance=? where accountnumber=?");
      st.setInt(1,balance-amount);
      st.setString(2, acno);
       result=st.executeUpdate();

         
                }
    }
    catch(Exception e)
    {
        System.out.println(e);
           JOptionPane.showMessageDialog(null, e);
    }
         return result;
    }

}


