<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta name="viewport">
	<title>Item List</title>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<c:import url="../template/header.jsp"></c:import>
	<!-- 이미지 크기 고정 -->
	<style type="text/css">
		.imgSize {
			height: 270px;
		}
	</style>
</head>
<body id="reportsPage" class="font">
	<c:import url="../template/topbar.jsp"></c:import>
	<div class="container">
        <div class="row">
            <div class="col">
				<h1 class="text-white mt-5 mb-5">STORE</h1>
				<c:if test="${users_info.user_auth == 0}">
					<a class="btn btn-primary" href="addItem">추가</a>
				</c:if>
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<div class="form-group mb-3">
						<!-- 검색기능 태그 -->
						<!-- 검색기능 태그 -->
							<div class="row">
							<div class="col-auto">
								<select id="kind" class="custom-select mr-sm-2">
								<option value="k1" id="option">종족</option>
								<option value="k2">가격</option>
								</select>
							</div>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="search">
							</div>
							<div class="col-auto">
								<button type="button" class="btn btn-primary" id="searchbtn">검색</button>
							</div>
							<!-- 검색기능 태그 -->
							<!-- 검색기능 태그 -->
							<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
							<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
							<div class="col-auto">
							<label for="category">분류</label>
							</div>
							<div class="col-sm-2">
							<select class="custom-select" id="category">
								<option value="0">캐릭터</option>
								<option value="1">무기</option>
							</select>
							</div>
							<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
							<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
							</div>
					</div>
				</div>
				
				
            	<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					
					<!-- list 비동기식 조회될 div -->
					<!-- list 비동기식 조회될 div -->
						<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
							<div id="itemListdiv" class="row justify-content-center" data-idto="${dto.category_num}">
								<h2 class="text-white">아이템명을 입력하고 검색해주세요.</h2>

							</div>
						</div>
				</div>
				<!-- list 비동기식 조회될 div -->
				<!-- list 비동기식 조회될 div -->

				<!-- 디테일 Modal -->
				 <!-- 디테일 Modal -->
				 <!-- Button trigger modal -->
					<a type="button" class="" data-bs-toggle="modal" data-bs-target="#exampleModal" id="modalBtn">
					</a>
					
					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
						<div class="modal-content" style="background-color:#4e657a;">
							<div class="modal-header">
							<h1 class="modal-title fs-5" id="exampleModalLabel">detail</h1>
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">X</button>
							</div>
							<div class="modal-body" id="modalContents">
							</div>
							<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							</div>
						</div>
						</div>
					</div>
					<!-- 디테일 Modal -->
					 <!-- 디테일 Modal -->
            	
            	
    		</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	<script src="/resources/js/store/storelist.js"></script>
</body>
</html>