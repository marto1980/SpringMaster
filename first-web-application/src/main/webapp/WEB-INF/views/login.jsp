<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>From JSP</title>
</head>
<%
System.out.println(request.getParameter("name"));
Date date = new Date();
%>
<div>Current date is <%=date%></div>
<body>
  My name is ${name} and password is ${password}
</body>
</html>
