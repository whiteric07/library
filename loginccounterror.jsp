<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XX大學選課系統</title>
</head>
<body>
		<div>
		<p>
			<strong>歡迎來到XX大學選課系統，請輸入您的資料來登入</strong>
		</p>
		<p>
			<strong><font color="#FF0000">輸入帳號錯誤，查無此帳號！</font></strong>
		</p>
		<form name="form" method="post" action="Login">
			<table>
				<tr>
					<td><div align="left">名稱:</div></td>
					<td><div align="left">
							<input type="text" name="user" id="user">
						</div></td>
				</tr>
				<tr>
					<td><div align="left">密碼:</div></td>
					<td><div align="left">
							<input type="password" name="password" id="password">
						</div></td>
				</tr>
			</table>
			<p>
			<label> 
			自動登入:<input type="checkbox" name="login" value="auto">
			</label>		
			<label> 
					<a href='AddNewUser'>新使用者？</a>
			</label>
			</p>
			<p>
				<label> 
					<input type="submit" name="submit2" value="送出">
				</label>
			</p>
		</form>
	</div>
</body>
</html>
