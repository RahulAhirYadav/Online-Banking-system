<%-- 
    Document   : Transaction
    Created on : Jun 24, 2023, 1:50:48 PM
    Author     : Rahul
--%>

<%@page import="model.TransactionDAO"contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

       
        <%
           String acno=request.getParameter("AccountNumber");
           int amount = Integer.parseInt(request.getParameter("amount"));
       TransactionDAO obj = new TransactionDAO();
       int r=obj.processTransaction(acno,amount);
          try{
             if(r>0)
             {
                 out.println("success to Transaction");
%>
<jsp:include page="Transaction.html"></jsp:include>
        <%
         }
             else{
                 out.println("Invalid Accountnumber");
                 %>


                 <jsp:include page="Transaction.html"></jsp:include>
                 <%

         }

             }
          catch(Exception ex){

         
}
        %>


    </body>
       </html>
