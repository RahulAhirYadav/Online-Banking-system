<%-- 
    Document   : Balance
    Created on : 23 Jun, 2023, 3:12:21 PM
    Author     : 9691r
--%>

<%@page   contentType="text/html" import="model.BalanceDAO,java.sql.ResultSet" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       

        <%
        String no = request.getParameter("Acc_no");
        String pass=request.getParameter("pass");
        BalanceDAO obj = new BalanceDAO();
        obj.setAcc_no(no);
        obj.setPass(pass);
   
         ResultSet rs= obj.getReccord();
        
         if(rs.next())
             {
            int balance = rs.getInt(1);

            
            
             out.println("Account Number: " + obj.getAcc_no() );
            out.println("Balance: " +balance);
           
            %>
            <jsp:include page="Balance.html"></jsp:include>
           
            <%
           }
            else{
                out.println("invalid accountnumber");
                %>
                <jsp:include page="Balance.html"></jsp:include>
                <%
                }
        
           
        %>
    </body>
</html>
