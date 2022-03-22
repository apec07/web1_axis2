<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="idv.cm.user.model.UserVO" %>

<!-- utility  -->
<%@ page import="java.util.List" %>


<jsp:useBean id="user_Svc" scope="page" class="idv.cm.user.model.UserDAO"/>

<!DOCTYPE html>
<html>
<head>
<title>User List</title>
</head>
<body>

<H2>Text Page</H2>
<TABLE border="1">
<TR>
<TH>NO</TH><TH>NAME</TH><TH>PASSWORD</TH><TH>EMAIL</TH>
</TR>
<c:forEach items="${user_Svc.allUser}" var="user">
<TR>
<td><div style="text-align:center;">${user.no }</div></td>
<td><div style="text-align:center;">${user.name }</div></td>
<td><div style="text-align:center;">${user.password }</div></td>
<td><div style="text-align:center;">${user.email }</div></td>
</TR>
</c:forEach>

	

</TABLE>

<H3>
<%out.println(user_Svc.getOneUser(2)); %>


</H3>
</body>
</html>