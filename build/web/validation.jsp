

<%@page import="model.LoginDAO" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="obj" class="model.LoginDAO" ></jsp:useBean>
        <jsp:setProperty name="obj" property="*"></jsp:setProperty>
<%
   String b=request.getParameter("button");
    
try{
     if(b.equals("User Login")){
         
   boolean r=obj.UserLogin();
   out.println(r);
   if(r){
       %>
       <jsp:forward page="home.html"></jsp:forward>
       <%
       }
   
     else{
         out.println("invalid login");
         %>
         <jsp:include page="project.html"></jsp:include>
         <%
         }
      }
     if(b.equals("Admin Login")){
         boolean A=obj.AdminLogin();
         if(A){
             %>
              <jsp:forward page="admin.html"></jsp:forward>
              <%
             }
         else{
             out.println("invalid  login");
             }
         }
     if(b.equals("createaccount")){
         %>
         <jsp:forward page="NewAccount.html"></jsp:forward>
         <%
     }
     }
catch(Exception e){
    out.println(e);
    }
    %>
    </body>
</html>