<%-- 
    Document   : account
    Created on : Jun 20, 2023, 1:53:43 PM
    Author     : Rahul
--%>

<%@page import="model.AccountDAO" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

         <jsp:useBean id="obj" class="model.AccountDAO" ></jsp:useBean>
        <jsp:setProperty name="obj" property="*"></jsp:setProperty>

        <%
        

try{
    
   

         int r=obj.insertRecord();
        
         if(r>0){
             out.println("success to create account");
        
                    %>
        <jsp:include page="NewAccount.html"/>
        <%
        }
         else{
          out.println("Not create account");
          %>
           <jsp:include page="NewAccount.html"/>
           <%
           }
         }
catch(Exception e){

    out.println(e);
    }

        %>

    </body>
</html>
