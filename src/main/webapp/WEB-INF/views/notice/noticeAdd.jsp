<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>NOTICE</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<c:import url="../template/topbar.jsp"></c:import>

    <div class="container tm-mt-big tm-mb-big">
    	<div class="row">
        	<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
          		<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
          			<!-- 타이틀 -->
            		<div class="row">
              			<div class="col-12">
                			<h2 class="tm-block-title d-inline-block">공지사항 새 글쓰기</h2>
              			</div>
            		</div>
            		<!-- 게시글 -->
            		<div class="row tm-edit-product-row">
          				<div class="col-xl-12 col-lg-6 col-md-12">
	              			<form action="noticeAdd" class="tm-edit-product-form" method="post">
	                			<input type="hidden" value="${users_info.user_id}" name="user_id">
			   					<!-- 제목 -->
	               				<div class="form-group mb-3">
	                 				<label for="name">제목</label>
					                    <input id="notice_title" name="notice_title" type="text" class="form-control validate" required/>
	                			 	</div>
			   					<!-- 컨텐츠 -->
			                  	<div class="form-group mb-3">
			                    	<label for="contents">내용</label>
			                    	<textarea class="form-control validate" name="notice_contents" id="editor" rows="10"required></textarea>
			                  	</div>
							   	<!-- 등록버튼 -->
				              	<div class="col-12">
				                	<button type="submit" name="noticeAdd" class="btn btn-primary btn-block text-uppercase">등록</button>
				             	</div>
	            			</form>
						</div>
            		</div>
          		</div>
       		</div>
		</div>
    </div>
   
	
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>

<!-- 	<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
	<script src="/resources/js/board/boardcontents.js"></script> -->

</body>
</html>