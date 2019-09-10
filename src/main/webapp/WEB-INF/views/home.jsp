<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>login</title>
	<script>
		function u_create() {
				location.href="/web/c_user";
		}
	</script>
</head>
<body>
<h1>로그인</h1>
<form action="" method="post">
id: <input type="text" name="id" id="id" placeholder="아이디를입격하세요"><br>
pw: <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요"><br>
<input type="submit" value="로그인" id="login">
<input type="button" value="회원가입" id="newUser" onclick="u_create()">
</form>
</body>
</html>
