<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script> 
</script>
<style>
	 li{
		display:inline;
		margin: 0 25px;
	}
</style>
</head>
<body>
<h1>${sessionScope.user} </h1> 
<form action="/web/board/create" method="post">
	제목:<input type="text" name="title">내용:<input type="text" name="comment"><input type="submit" value="추가"><input type="button" value="수정" ><input type="submit" value="삭제">
</form>
	<ul class="listhead">
		<li>제목</li><li>내용</li><li>작성자</li>
	</ul>
	<ul>
		<li>1
		<li>2
		<li>3
	</ul>

</body>
</html>