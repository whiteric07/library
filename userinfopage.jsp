<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>線上圖書借閱系統</title>
</head>
<body>

	<div>
		<p>
			<strong>恭喜您完成線上圖書借閱系統的註冊，您所填寫的資料如下：</strong>
		</p>
		<table>
			<tr>
				<td><div align="left">手機號碼:</div></td>
				<td><div align="left"><%=session.getAttribute("user") %></div></td>
			</tr>
			<tr>
				<td><div align="left">帳戶密碼:</div></td>
				<td><div align="left"><%=session.getAttribute("password") %></div></td>
			</tr>
		</table>
		<p>
			<label> <a href='Login'>請回到首頁進行登入動作！</a>
			</label>
		</p>
	</div>
</body>
</html>
