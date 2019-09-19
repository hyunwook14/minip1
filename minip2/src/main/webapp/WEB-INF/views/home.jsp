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
			cell.innerHTML ="<a href='/minip2/detail/"+i+"'>"+ i+"</a>" + "<br><input type='checkbox' onclick='attendcheck("+i+")'>";
			cnt = cnt + 1;
			if ( cnt % 7 == 1){
				cell.innerHTML = "<a href='/minip2/detail/"+i+"'>"+ i+"</a>"  +"<br><input type='checkbox' onclick='attendcheck("+i+")'>";
			}
			if( cnt % 7 == 0){
				cell.innerHTML ="<a href='/minip2/detail/"+i+"'>"+ i+"</a>"  +"<br><input type='checkbox' onclick='attendcheck("+i+")'>";
				row=calendar.insertRow();
			}
			if(today.getFullYear()==date.getFullYear()&&today.getMonth()==date.getMonth()&&i==date.getDate()){
				cell.bgColor = "#BCF1B1"; //오늘날짜배경색
			}
		}
		
		var checklist = document.getElementsByTagName("input");
		
		
		 for(var i = 0 ; i <checklist.length; i++){
			if(date.getDate()-1 > i)
			 checklist[i].disabled = true;
		} 
		console.log("체크불러오기시작")
		select();
	}
	
	function attendcheck(item){
		console.log("itemindex: ", item)
		var checklist = document.getElementsByTagName("input");
		var flag = checklist[item - 1].checked;
		
		console.log(flag,"--flag1")
		
		httpRequest.open("POST", "/minip2/attendcheck");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
		httpRequest.send("id=${sessionScope.id}&day="+item+"&flag="+flag);
		
		httpRequest.onreadystatechange = function(){
			if(this.readyState ==4 ){
				if(this.responseText == "1"){
					alert("성공");
				}else {
					alert("실패");
				}
			}
		}
	}
	
	function select(){
		console.log("체크실행함수 시작")
		httpRequest.open("POST", "/minip2/checkselect");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
		httpRequest.send(); 
		
		httpRequest.onreadystatechange = function(){
			console.log(this)
			if(this.readyState ==4 ){
				console.log(this.responseText, "---돌아온데이터")
				//var data = JSON.parse(this.responseText);
				var data = JSON.parse(this.responseText);
				console.log(data)
				console.log(data[0])
				
				for(var i =0 ; i<data.length; i++){
					if(data[i].check ==1)
						document.getElementsByTagName("input")[data[i].day-1].checked= true
				}
				
			}
		}
	}
	
	function logout(){
		location.href="/minip2/logout";
	}
	
</script>
</head>
<body onload="build();">
<h1>calendar</h1>
<h2>user: ${sessionScope.id}</h2>
<h3 id ="month"></h3>
<button onclick="logout()">로그아웃</button>
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