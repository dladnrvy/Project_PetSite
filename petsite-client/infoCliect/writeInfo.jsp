<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>   
</head>
<body>
	<!-- 취소 저장
		작성자 아이디 : 수정불가 
		제목 , 내용 
	 -->
	<div id="contents">
	<h3>유용한 정보</h3>
	
		<a id="cencle" href="main.jsp">취소</a>
	<form id="form" enctype="multipart/form-data">
		<input type="submit" value="작성">
		<input type="text" name="uId" id="uId" value="${sessionScope.id}" readonly>
		<input type="text" name="title" id="title">
		<input type="file" name="photo" id="photo">
		<textarea rows="3" cols="30" name="text" id="text"></textarea>
	</form>
	
	
	</div>
</body>	
<script>
	$(document).ready(function() {
        
    
		$('#form').submit(function() {
			
            /*var form = $('#form')[0];*/
            var formData = new FormData();
            
            formData.append("uId",$('#uId').val());
            formData.append("title",$('#title').val());
            formData.append("text",$('#text').val());
            formData.append("photo",$('#photo')[0].files[0]);
            
			$.ajax({
				
				url: 'http://localhost:8080/info/infoMain',
				type : 'POST',
				data : formData,
                contentType: false,
                processData: false,
				success : function(data) {
					alert('글이 작성되었습니다.');
                    location.href = "main.jsp";
				}			
				
			});
			return false;
		});
        
        
        $('#cencle').click(function(){
            
            
            
            
        });
        

     });
    
		
	


</script>



</html>