<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 취소 저장
		작성자 아이디 : 수정불가 
		제목 , 내용 
	 -->
	<div id="contents">
	<h3>유용한 정보</h3>
	
		<input type="button" value="취소">
	<form enctype="multipart/form-data" method="post" id="form">
		<input type="submit" value="작성">
		
		
		<input type="text" name="title" value="제목">
		<input type="file" name="photo">
		<textarea rows="3" cols="30" name="text"></textarea>
	</form>
	
	
	</div>
	
<script>
	$(document).ready(function() {
		
		$('#form').submit(function() {
			
			$.ajax({
				
				url: 'http://localhost:8080/info/write',
				type : 'POST',
				data : $('#form').serialize(),
				success : function (data) {
					alert(data);
				}
				
				
				
				
				
			});
			
		});
		return false;
	});


</script>


</body>
</html>