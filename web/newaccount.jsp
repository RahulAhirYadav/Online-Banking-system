<%-- 
    Document   : newaccount
    Created on : Jul 7, 2023, 12:40:11 AM
    Author     : Rahul
--%>

<%@page import="model.newAccountDAO" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <%
        String name=request.getParameter("name");
        String accountnumber=request.getParameter("accountnumber");
           int balance = Integer.parseInt(request.getParameter("balance"));




try{
    newAccountDAO obj = new newAccountDAO();

         int r=obj.newaccount(accountnumber,balance,name);
         if(r>0){
             out.println("success to Genret  account");
        
                    %>
        <jsp:include page="admin.html"/>
        <%
        }
         else{
          out.println("Not Genret account");
          %>
          <jsp:include page="admin.html"/>
          <%

             }

         }

catch(Exception e){
    out.println(e);
    }
%>
    </body>
</html>
