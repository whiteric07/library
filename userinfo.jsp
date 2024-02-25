<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controller.User" %>
<%@ page import="java.util.HashMap" %>
<%!
	boolean checkUser(String inputAccountName, HashMap<String, User> hashMap) {

	if (hashMap == null)
		return false;

	User user = hashMap.get(inputAccountName);

	String AccountNameOnRecord = user.getAccountName();
	if (inputAccountName.equals(AccountNameOnRecord))
		return true;
	else
		return false;
}
%>
<% User user = new User(); %>
<%
	ServletContext context = request.getServletContext();
	HashMap<String, User> userdata = (HashMap<String, User>) context.getAttribute("userdata");
%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX大學選課系統</title>
</head>
<body>
	<% 
		String acuser = (String)session.getAttribute("user1");
		String acpassword = (String)session.getAttribute("password1");  	
	%>
	<div>
		<p>
			<strong><%=userdata.get(acuser).getName() %>，歡迎您登錄XX大學選課系統！</strong>
		</p>
		<p>您的基本資料如下：</p>
		<% if(checkUser(acuser, userdata)) { %>
		<table>
			<tr>
				<td><div align="left">姓名:</div></td>
				<td><div align="left"><%=userdata.get(acuser).getName() %></div></td>
			</tr>
			<tr>
				<td><div align="left">學號:</div></td>
				<td><div align="left"><%=userdata.get(acuser).getstudentNumber() %></div></td>
			</tr>
			<tr>
				<td><div align="left">電話:</div></td>
				<td><div align="left"><%=userdata.get(acuser).getPhoneNumber() %></div></td>
			</tr>
			<tr>
				<td><div align="left">住址:</div></td>
				<td><div align="left"><%=userdata.get(acuser).getAddress() %></div></td>
			</tr>
		</table>
		<%}%>
		
		<p>
			<label> 
				<a href='addCourse.jsp'>下一頁</a>
				<a href='Logout'>登出</a>
			</label>
		</p>
	</div>
</body>
</html>
