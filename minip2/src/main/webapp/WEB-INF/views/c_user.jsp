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
		var clickflag = 1;
		var pwdflag = 1;
		
		$("form").submit(function(){
			if(clickflag == 1 || pwdflag == 1){
				alert("회원정보를확인해주세여");
				return false;
			}
		});
		
		$("input[type=button]").click(function (){
			
			var id =$("#id").val();
			
			 $.ajax({
				 url:"/minip2/idcheck",
				 type:"post",
				 data:{"id": id},
				 success: function(data){
					 if(data == 0){
						 alert("아이디 사용가능합니다");
						 clickflag = data;
						 console.log(clickflag, "--ajaxdata")
						 $("#id").css("borderColor", "");
					 }else{
						 alert("아이디 중복됩니다.");
						 $("#id").css("borderColor", "red");
					 }
				 }
			 });
		});
		
		$("input[type=password]").eq(1).change(function(){
			if ($("input[type=password]").eq(0).val() != ""){
				var pw1 = $("input[type=password]").eq(0).val();
				var pw2 = $("input[type=password]").eq(1).val();
				if(pw1 == pw2){
					pwdflag= 0;
					alert("비밀번호가 일치합니다.");
					$("input[type=password]").eq(0).css("borderColor","");
					$("input[type=password]").eq(1).css("borderColor","");
				}else{
					pwdflag=1;
					alert("비밀번호가 일치하지 않습니다");
					$("input[type=password]").eq(0).css("borderColor","red");
					$("input[type=password]").eq(1).css("borderColor","red");
				}
			}
		});
		
		
	});

</script>
</head>
<body>
<h1>회원가입</h1>
<form action="/minip2/create_u" method="post">
ID:<input type="text" name="id" id="id" placeholder="아이디를입력해주세요"> <input type="button" value="중복확인"><br>
PW:<input type="password" name="pwd" placeholder="비밀번호를입력해주세요"><br>
확인:<input type="password" name="pwd2" placeholder="비밀번호재확인해주세요"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>