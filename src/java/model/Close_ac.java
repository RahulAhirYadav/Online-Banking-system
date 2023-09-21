/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author 9691r
 */
public class Close_ac {
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    


    public Close_ac() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","admin","");
        }
        catch(Exception ex){
        System.out.println(ex);
        }
    }

   
    
    public int DeletAccount(String accno){
int b=0;
        try{
            

    
    ps= (PreparedStatement) con.prepareStatement("delete from account where accountnumber=?");
    ps.setString(1, accno);
   b = ps.executeUpdate();
    
    }catch(Exception e){
        System.out.println(e);
    }
    return b ;
    }


}
