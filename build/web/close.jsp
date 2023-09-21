<%-- 
    Document   : close
    Created on : 3 Jul, 2023, 3:36:33 PM
    Author     : 9691r
--%>

<%@page  contentType="text/html" import="model.Close_ac"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
        String accno=request.getParameter("acc_no");
        
        Close_ac obj =new Close_ac();
       int r= obj.DeletAccount(accno);
       if(r>0){
       
       %>
       <jsp:include page="project.html"></jsp:include>
       <%
       }else{
       out.println("some problem");
       }

%>

    </body>
</html>
