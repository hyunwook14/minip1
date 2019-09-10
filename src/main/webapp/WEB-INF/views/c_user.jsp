<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	
	function pwd_check(){
		if(document.getElementsByName("pwd")[0].value == "") console.log("아무것도없습니다")
		else{
			
		}
	}
	
	
	
	
</script>
</head>
<body>
<h1>회원가입</h1>
<form action="/web/c_user" method="post">
	id:<input type="text" name="id" placeholder="아이디를입력하세요"><br>
	pw:<input type="password" name="pwd" placeholder="비밀번호를입력하세요" onclick="pwd_check()"><br>
	<input type="submit" value="회원가입">
</form>

</body>
</html>