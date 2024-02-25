<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>線上圖書借閱系統</title>
</head>
<body>
<body>
	<div>
		<p>
			<strong>請設定您的手機密碼</strong>
		</p>
		<p>
			<strong><font color="#FF0000">所輸入的手機已經有人使用，請輸入另一支手機！</font></strong>
		</p>
		<form name="form" method="post" action="AddNewUser">
			<table>
				<tr>
					<td><div align="left">新增手機號碼:</div></td>
					<td><div align="left">
							<input type="text" name="user" id="user" required>
						</div></td>
				</tr>
				<tr>
					<td><div align="left">新增帳戶密碼:</div></td>
					<td><div align="left">
							<input type="password" name="password" id="password" required>
						</div></td>
				</tr>
			</table>
			<p>
				<label> 
					<input type="reset" name="reset" value="重設">
					<input type="submit" name="submit2" value="送出">
				</label>
			</p>
		</form>
	</div>
</body>
</html>
