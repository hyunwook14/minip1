<%@page import="com.java.web.DAO.AttendCheck"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석체크자세히보기</title>
<script>
	
</script>
</head>
<body>
<h1>출석현황</h1>
<% List<AttendCheck> list = (List<AttendCheck>)request.getAttribute("list"); 
 		if(list == null) System.out.println("null값입니다");
 		else{
 %>
<h2><%= list.get(0).getDay() %>일 인원</h2>
 <ul id="person">
 	
 	<%		
 		for(int i =0; i<list.size(); i++){
 			
 	%> <li><%= list.get(i).getId() %> </li>
 	<%
 			}
 		} 	
 	%>
 </ul>
</body>
</html>