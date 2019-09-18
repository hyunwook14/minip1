<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<html>
<head>
<style type='text/css'>
	table
    {
        border:1px solid #BDBDBD;
        text-align:center;
        width:30%;
    }
</style>
<script>
	var today = new Date();
	var date = new Date();
	var httpRequest = new XMLHttpRequest();
	
	function build(){
		var nMonth = new Date(today.getFullYear(), today.getMonth(), 1);
		var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		var tbcal = document.getElementById("calendar");
		
		document.getElementById("month").innerHTML = (today.getMonth()+1)+"월";
		
		 while(tbcal.rows.length >3){
			tbcal.deleteRow(tbcal.rows.length - 1);
		} 
		var row = null;
		row = tbcal.insertRow();
		var cnt =0;
		
		for(i = 0; i < nMonth.getDay(); i++){
			cell = row.insertCell();
			cnt = cnt + 1;
		}
		
		for( i = 1; i <= lastDate.getDate(); i++){
			cell = row.insertCell();
			cell.innerHTML = i + "<br><input type='checkbox' onclick='attendcheck()'>";
			cnt = cnt + 1;
			if ( cnt % 7 == 1){
				cell.innerHTML = i +"<br><input type='checkbox' onclick='attendcheck()'>";
			}
			if( cnt % 7 == 0){
				cell.innerHTML = i +"<br><input type='checkbox' onclick='attendcheck()'>";
				row=calendar.insertRow();
			}
			if(today.getFullYear()==date.getFullYear()&&today.getMonth()==date.getMonth()&&i==date.getDate()){
				cell.bgColor = "#BCF1B1"; //오늘날짜배경색
			}
		}
	}
	
	function attendcheck(){
		var checklist = document.getElementsByTagName("input");
		var flag = false;
		var index= [];
		for(var i = 0 ; i < checklist.length; i++){
			if(checklist[i].checked){
				flag = checklist[i].checked;
				index[index.length] = i+1;
			}
		}
		
		console.log( index , "-index")
		httpRequest.open("POST", "/minip2/attendcheck");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
		httpRequest.send("id=${sessionScope.id}&day="+index);
		
		httpRequest.onreadystatechange = function(){
			console.log(this.readyState, this.responseText, this);
			if(this.readyState ==4 ){
				console.log(this);
				if(this.responseText == "1"){
					alert("성공");
				}else {
					alert("실패");
				}
			}
		}
		
		
	}
	
</script>
</head>
<body onload="build();">
<h1>calendar</h1>
<h2>user: ${sessionScope.id}</h2>
<h3 id ="month"></h3>
<table id ="calendar">
	<tr>
	</tr>
	<tr>
		<td>일</td>
		<td>월</td>
		<td>화</td>
		<td>수</td>
		<td>목</td>
		<td>금</td>
		<td>토</td>
	</tr>
	
</table>
</body>
</html>