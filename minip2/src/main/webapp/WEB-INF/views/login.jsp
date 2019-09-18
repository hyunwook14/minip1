<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="/minip2/logincheck" method="post">
ID:<input type="text" name="id" placeholder="아이디를입력해주세여"><br>
PW:<input type="password" name="pwd" placeholder ="비밀번호를 입력해주세요"><br>
<input type="submit" value="로그인"><button>회원가입</button>
</form>
</body>
</html>