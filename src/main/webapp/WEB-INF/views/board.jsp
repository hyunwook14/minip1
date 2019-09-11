<%@page import="com.java.web.bean.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page session = "true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script> 
	var arr;
	var index;
	var httpRequest = new XMLHttpRequest();
	
	if(httpRequest ==null){
		alert("ajax 실패");
	}
	function logout(){
		location.href = "/web/logout" ;
	}
	function clickme(e){
		
		for(var i =0; i<document.getElementsByClassName("boardlist").length; i++){
			if(e == document.getElementsByClassName("boardlist")[i].outerText.split(" ")[0])
			{
				arr = document.getElementsByClassName("boardlist")[i].outerText.split(" ");
				index =i;
			}
		}
		
		document.getElementsByName("title")[0].value= arr[1];
		document.getElementsByName("comment")[0].value= arr[2];
	}
	
	function update(){
		
		httpRequest.open("POST", "/web/board/update");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
		httpRequest.send("no="+arr[0]+"&title="+document.getElementsByName("title")[0].value+
				"&comment="+document.getElementsByName("comment")[0].value+"&id="+arr[3]);
		
		httpRequest.onreadystatechange = function(){
			console.log(this.readyState, this.responseText, this);
			if(this.readyState ==4 ){
				console.log(this);
				if(this.responseText == "1"){
					location.href="/web/board";
					alert("성공");
				}else {
					alert("권한이없습니다");
				}
			}
		}
	}
	
	function deleted(){
		
		httpRequest.open("POST", "/web/board/delete");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
		httpRequest.send("no="+arr[0]+"&title="+arr[1]+
				"&comment="+arr[2]+"&id="+arr[3]);
		httpRequest.onreadystatechange = function(){
			console.log(this.readyState, this.responseText, this);
			if(this.readyState ==4 ){
				console.log(this);
				 if(this.responseText == "1"){
					location.href="/web/board";
					alert("성공");
				}else {
					alert("권한이없습니다");
				} 
			}
		}
		
	}
</script>
<style>
	 li{
		display:inline;
		margin: 0 25px;
	}
	.boardlist li:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
<h1>${sessionScope.user} </h1> <button onclick="logout()">로그아웃</button>
<form action="/web/board/create" method="post">
	제목:<input type="text" name="title">
	내용:<input type="text" name="comment">
	<input type="submit" value="추가">
	<input type="button" value="수정" onclick="update()">
	<input type="button" value="삭제" onclick="deleted()">
</form>
	<ul class="listhead">
		<li>번호</li><li>제목</li><li>내용</li><li>작성자</li>
	</ul>
	<% List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
		if(list == null) {
			System.out.println("값이없습니다");
		}else{
			
		for(int i =0 ; i<list.size(); i++){
	%>
	<ul class="boardlist" onclick="clickme( <%= list.get(i).getNo() %> )" >
		<li><%= list.get(i).getNo() %>
		<li><%= list.get(i).getTitle() %>
		<li><%= list.get(i).getComment()%>
		<li><%= list.get(i).getId()%>
	</ul>
	<%
			}	
		}
	%>

</body>
</html>