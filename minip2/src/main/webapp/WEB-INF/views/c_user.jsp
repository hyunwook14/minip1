<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

	$(document).ready(function(){
		
		$("input[type=button]").click(function (){
			
			var id =$("#id").val();
			
			 $.ajax({
				 url:"/minip2/idcheck",
				 type:"post",
				 data:{"id": id},
				 success: function(data){
					 if(data == 0){
						 alert("아이디 사용가능합니다");
					 }else{
						 alert("아이디 중복됩니다.");
					 }
				 }
			 });
		});
		
		$("input[type=password]").eq(0).keydown(function(){
			alert("test");
		});
		
		if ($("input[type=password]").eq(0).val() != ""){
			var pw1 = $("input[type=password]").eq(0).val();
			var pw2 = $("input[type=password]").eq(1).val();
			
			
			
		}
		
		
	});

</script>
</head>
<body>
<h1>회원가입</h1>
<form action="/minip2/create_u" method="post">
ID:<input type="text" name="id" id="id" placeholder="아이디를입력해주세요"> <input type="button" value="중복확인"><br>
PW:<input type="password" name="pwd" placeholder="비밀번호를입력해주세요"><br>
확인:<input type="password" name="pwd" placeholder="비밀번호재확인해주세요"><br>
email:<input type="email" name="email" placeholder="필수사항은 아닙니다."><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>