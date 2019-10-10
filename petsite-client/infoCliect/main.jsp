<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>Time Lapse</title>

<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>

<style>
.formBlock {
	margin: 15px;
}

#formDiv {
	margin: 0 auto;
	width: 50%;
}

.main {
	display: inline-block;
	width: 250px;
	height: 370px;
	border: 2px solid #DDD;
	margin: 5px;
	text-align: center;
}

#pho {
	width: 240px;
	height: 240px;
	margin-top: 10px;
	margin-bottom: 10px;
}

#info {
	display: none;
}

#update {
	display: none;
}

#photo {
	cursor: pointer;
}

.youtube.img {
	width: 400px;
	height: 400px;
}
</style>

</head>

<body>
	<!-- nav 시작 -->
	<%@include file="frame/nav.jsp"%>
	<!-- nav 끝 -->


	<div class="main" style="background-image: url('images/backgroud.jpg')">
		<div class="cover black" data-color="white"></div>

		<!-- context시작 -->
		<div class="container">
			<h1 class="logo cursive">Login</h1>
			<br>
			<div class="content">
				<h4 class="motto">로그인 해주세요</h4>
				<div class="subscribe">
					<!--<h5 class="info-text">
                        Join the waiting list for the beta. We keep you posted.
                    </h5>-->

					<div id="formDiv">
						<form id="form" class="form-inline" role="form">
							<div id="contents">
								<h3>유용한 정보/반려동물훈련법</h3>
								<hr>
								<br>
								<form name="form" method="post" onSubmit="return false;">
									<input type="text" id="search_box">
									<button onClick="GetList();">영상검색</button>
								</form>
								<div id="getview"></div>
								<div id="getview2"></div>
								<div id="getview3"></div>
								<div id="view"></div>

								<div id="search">
									<form id="SearchForm">
										<input type="text" id="searchTitle"> <input
											type="submit" value="게시물검색">
									</form>
									<a href="writeInfo.jsp">글쓰기</a> <br> <br>
								</div>
								<div id="list"></div>
								<div id="textList"></div>
								<div id="selectList"></div>

								<div id="photodiv">
									<form id="photoform" enctype="multipart/form-data">
										<input type="file" name="photo" id="photo"> <input
											type="submit" value="사진수정">
									</form>
								</div>

								<div id="update">
									<form id="form">
										<br> <input type="button" value="취소" id="cencle">
										<input type="submit" value="수정"><br> <input
											type="text" name="uId" id="uId"><br> <input
											type="text" name="title" id="title"><br>
										<textarea rows="3" cols="30" name="text" id="text"></textarea>
									</form>

								</div>

							</div>
							<hr>
						</form>
						<span id="span"></span>
					</div>
				</div>
			</div>
		</div>
		<!-- context끝 -->

		<!-- footer 시작 -->
		<%@include file="frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>

	<script>
	$(document).ready(function() {
       list();       
    });
    
        /*전체리스트*/
		function list() {
			
            $('#list').css('display','block');
            $('#search').css('display','block');
            $('#photodiv').css('display','none');
            
			$.ajax({	
				url: 'http://localhost:8080/info/infoMain',
				type : 'GET',
                /*dataType: 'json',*/
                /*enctype: 'multipart/form-data',*/
                contentType : false,
                processData : false,
				success : function(data) {
                    
                    var html = '';
                
                    
                    
					for(i=0; i<data.length; i++){
                        html += '<div class="main">'
                        html += '<div id="idx">'+data[i].idx+'</div>\n';
                        html += '<div class="list"><img onclick="textList('+data[i].idx+')" id="pho" src="http://localhost:8080/info/uploadfile/'+data[i].photo +'"/></div>\n';
                        html += '<div class="list">'+data[i].title +'</div>\n';
                        html += '<div class="list">'+data[i].uId +'</div>\n';
                        html += '<div class="list">'+data[i].date.substr(0,16)+'</div>\n'; 
                        html += '</div>'
                        /*html += '수정'*/
                    }
					/* for(i=0; i<data.length; i++){
					for(j=1; j<data[i].num; j++){
                        html += '<div class="list"><button onclick="pagenum('+data[i].num+')">'+data[j].num+'</button></div>';
                        }
					} */

                    
                    $('#list').html(html);
				}			
				
			});
		};
    
   
    
			
        
        
        /*게시물*/
        function textList(idx) {
			
            /*$('#textList').css('display','block');*/
            $('#list').css('display','none');
            $('#search').css('display','none');
            
			$.ajax({	
				url: 'http://localhost:8080/info/infoMain/'+idx,
				type : 'GET',
                /*dataType: 'json',*/
                /*enctype: 'multipart/form-data',*/
                contentType : false,
                processData : false,
				success : function(data) {
                    
                    var html = '';  
                    
                    html += '<div class="list">\n';
                    html += '아이디 : '+data.uId+' 님의 글입니다. <br>\n';
                    html += '</div>\n';
                    html += '<div class="list">\n';
                    html += '제목 : '+data.title +'</div>\n';
                    html += '<div class="list">\n';
                    html += '<img id="pho" src="http://localhost:8080/info/uploadfile/'+data.photo +'"/></div>\n';
                    html += '<div>\n';
                    html += '내용 : '+data.text+'</div>';
                    html += '<div id="choice">';
                    html += '<a href="main.jsp">리스트</a>';
                    if('${sessionScope.id}' == data.uId){
                    html += '<button onclick ="del('+data.idx+')">삭제</button>';
                    html += '<button onclick ="put('+data.idx+')">수정</button>';
                    html += '<button onclick ="putPhoto('+data.idx+')">이미지 수정</button>';
                    }
                    html += '</div>';
                          
                    $('#textList').html(html);
				}			
				
			});
		};
    
    
        /*수정*/
        function put(idx){     	
            
            $('#list').css('display','none');
            $('#search').css('display','none');
            $('#update').css('display','block');
            $('#photodiv').css('display','none');
            
            $('#form').submit(function(){    

            var getidx = idx;
            
			$.ajax({
                url : 'http://localhost:8080/info/infoMain/'+idx,
                type : 'PUT',
               data : JSON.stringify({
            	 uId : $('#uId').val(),
            	 title : $('#title').val(),
                 text : $('#text').val()
               }),       
                contentType: 'application/json; charset=utf-8',
				success : function(data) {
                    if(data == 'success'){
					alert('정상적으로 수정되었습니다.');
				}else{
                        alert('오류닷');
                    }
				}			
				
			});
			
		  });
            return idx;
       };
       
       /*사진수정*/
       function putPhoto(idx){
           
    	   var getidx = idx;
    	   
           $('#list').css('display','none');
           $('#search').css('display','none');
           $('#update').css('display','none');
           $('#photodiv').css('display','block');  
           
           $('#photoform').submit(function(){
        	   
           var formData = new FormData(form);
           
           formData.append("photo",$('#photo')[0].files[0]);
      
			$.ajax({
               url : 'http://localhost:8080/info/photoUpdate/'+idx,
               type : 'POST',
              data : formData,
               contentType: false,
               processData: false,
				success : function(data) {
                   if(data == 'success'){
					alert('이미지가 정상적으로 수정되었습니다.');
					
				}else{
                       alert('오류');
                   }
				}			
				
			});
			
		  });
           return idx;
      };
    
    
        /*삭제*/
        function del(idx){
            
            if(confirm('정말 삭제하시겠습니까?')){
            $.ajax({
                url : 'http://localhost:8080/info/infoMain/'+idx,
                type : 'DELETE',
         /*       contentType: false,
                processData: false,*/
				success : function(data) {
                    if(data == 'success'){
					alert('삭제되었습니다.');
					location.href = "main.jsp"
                    }else{
                        alert('오류');
                    }
				}			
				
			 });
            };
        };
    
    
       
     
        /*검색 title 전달*/
            $('#SearchForm').submit(function(){
            	if($('#searchTitle').val() == ""){
                	location.href = "main.jsp";
                	}else{	
             		   $.ajax({
                   url : 'http://localhost:8080/info/search/'+$('#searchTitle').val(),
                   type : 'GET',
                   contentType : false,
                   processData : false,
				   success : function(data) {
                    var html = '';

					for(i=0; i<data.length; i++){
                        html += '<div class="main">'
                        html += '<div>'+data[i].idx+'</div>\n';
                        html += '<div><img onclick="textList('+data[i].idx+')" id="pho" src="http://localhost:8080/info/uploadfile/'+data[i].photo +'"/></div>\n';
                        html += '<div>'+data[i].title +'</div>\n';
                        html += '<div>'+data[i].uId +'</div>\n';
                        html += '<div>'+data[i].date.substr(0,16)+'</div>\n';
                        /* for(j=1; j<data[i].num; j++){
                            html += '<div class="list"><button onclick="pagenum('+data[i].title+','+data[i].num+')">'+data[j].num+'</button></div>';
                            } */
                            html += '</div>'
                        /*html += '수정'*/
						}

					$('#selectList').html(html);
					$('#list').css('display','none');
			        $('#update').css('display','none');
                      
					}               
                });
                return false;
            	}
            });      
        
        
       /*  function pagenum(title,num) {
        	if(title == null){
        		title == "";
        	}
			
        	$.ajax({
                url : 'http://localhost:8080/info/search/'+title+'/'+num,
                type : 'GET',
                contentType : false,
                processData : false,
				success : function(data) {
                    
                    var html = '';
            
					for(i=0; i<data.length; i++){
                        html += '<div class="main">'
                        html += '<div id="idx">'+data[i].idx+'</div>\n';
                        html += '<div class="list"><img onclick="textList('+data[i].idx+')" id="pho" src="http://localhost:8080/info/uploadfile/'+data[i].photo +'"/></div>\n';
                        html += '<div class="list">'+data[i].title +'</div>\n';
                        html += '<div class="list">'+data[i].uId +'</div>\n';
                        html += '<div class="list">'+data[i].date.substr(0,16)+'</div>\n';
                        for(j=1; j<data[i].num; j++){
                        html += '<div class="list"><button onclick="pagenum('+data[i].num+')">'+data[j].num+'</button></div>';
                        }
                        html += '</div>'
                    }

                    
                    $('#list').html(html);
				}			
				
			});
        		
        		
        		
        	}; */
        	
        	//유튜브 검색
        	function GetList(GetToken){
    			var getval = $("#search_box").val();
    			if(getval==""){
    				alert("검색어를 입력하세요.");
    				$("#search_box").focus();
    				return;
    			}
    			/* $("#getview").empty();
    			$("#view").empty(); */
    			
    			var youtubeUrl = "https://www.googleapis.com/youtube/v3/search?part=snippet&order=relevance"
    								+ "&q="+ encodeURIComponent(getval) +"&type=video&videoDefinition=high&maxResults=3&key=AIzaSyAcezwf-iUpTYkBw2neqfl99jL8xFhSRfU";
    			
    			if(GetToken){
    				youtubeUrl += "&pageToken="+GetToken;		
    			}
    			
    			
    			$.ajax({
    				type: "GET",
    				url: youtubeUrl,
    				dataType: "json",
    				success: function(data) {
    					var tag = document.createElement('script');
                 			 tag.src = "https://www.youtube.com/iframe_api";
                 		var firstScriptTag = document.getElementsByTagName('script')[0];
                  firstScriptTag.parentNode.insertBefore(tag,firstScriptTag);

                  var player;
                  
                  var a = ['getview', 'getview2', 'getview3'];
                  
                  
                  onYouTubeIframeAPIReady = function(event) {
                     
                     for(var i = 0; i<3; i++){
                        
                        var a2 = a[i];
                     player = new YT.Player(
                           a2,
                           {
                              videoId : data.items[i].id.videoId,
                              height : '360px',
                              width : '100%'
                           });
                     
                     }
    						
    					
                  }
    			}
    		});
        	}
		
   
    
    
        
    
        

     
    
		
	


</script>
</body>
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>