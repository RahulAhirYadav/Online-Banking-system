<%-- 
    Document   : Depojsp
    Created on : Jun 22, 2023, 2:54:12 PM
    Author     : Rahul
--%>

<%@page import="model.DepoDAO" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        <%
        String accno=request.getParameter("accountnumber");
        int amount=Integer.parseInt(request.getParameter("amount"));
        
        
        DepoDAO obj=new DepoDAO();
      int r=obj.UpdateRecord(accno,amount);
       try{
        if(r>0){
            out.println("Success to diposite ");
            %>
            <jsp:include page="Deposite.html"></jsp:include>
        <%
        }
       else{
           out.println("invalid Accountnumber");
            %>
            <jsp:include page="Deposite.html"></jsp:include>
        <%
           }
        }
       catch(Exception e){

        out.println( e);
           }

       

       
         
         
        %>

    </body>
</html>
