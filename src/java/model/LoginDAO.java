/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Rahul
 */
public class LoginDAO {
    Connection con;
    Statement st;
    ResultSet rs;
    private String name;
    private String pass;


        public LoginDAO(){

            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","admin","");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);


            }
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   

        public boolean UserLogin(){
            boolean b=false;
            try{
                st=con.createStatement();
                rs=st.executeQuery("select*from account");
                while(rs.next()){
                    String n=rs.getString(1);
                    String p=rs.getString(5);
                   
                    if(n.equals(name)&& p.equals(pass)){
                       b=true;

                    }
                   
                    
                }
           
            }
            catch(Exception e){
              
                System.out.println(e);
            }
          return b;
        }
        public boolean AdminLogin(){
            boolean b=false;
            try{
                st=con.createStatement();
                rs=st.executeQuery("select*from admin");
                while(rs.next()){
                    String n=rs.getString(1);
                    String p=rs.getString(2);
                   
                    if(n.equals(name)&& p.equals(pass)){
                       b=true;

                    }
                   
                    
                }
           
            }
            catch(Exception e){
              
                System.out.println(e);
            }
          return b;
        }



   
}






       


