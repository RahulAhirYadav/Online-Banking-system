
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 9691r
 */
public class BalanceDAO {
private String Acc_no;
private String pass;


Connection con;
Statement st;
PreparedStatement ps;
ResultSet rs;

    public BalanceDAO() {
        try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","admin","");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public String getAcc_no() {
        return Acc_no;
    }

    public void setAcc_no(String Acc_no) {
        this.Acc_no = Acc_no;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   

   
public ResultSet getReccord(){
   
    //int r=0;
try{
    ps=con.prepareStatement("select balance from account where accountnumber=?&& password=?");
    
     ps.setString(1,Acc_no);
     ps.setString(2, pass);
       rs = ps.executeQuery();
      
}
catch(Exception ex){
    System.out.println(ex);

}
return rs;
}


}
