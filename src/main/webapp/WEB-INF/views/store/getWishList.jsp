<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Item List</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
				<h1 class="text-white mt-5 mb-5">STORE</h1>
				<a class="btn btn-primary" href="addItem">추가</a>
					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<!-- 검색기능 태그 -->
					<!-- 검색기능 태그 -->
					<div class="form-row align-items-center">
						<div class="col-auto">
							<select id="kind" class="custom-select mr-sm-2">
							<option value="k1">종족</option>
							<option value="k2">가격</option>
							</select>
					    </div>
					    <div class="col-sm-3 my-1">
							<input type="text" class="form-control" id="search">
					    </div>
					    <div class="col-auto my-1">
							<button type="button" class="btn btn-primary" id="searchbtn">검색</button>
					    </div>
					</div>
					<!-- 검색기능 태그 -->
					<!-- 검색기능 태그 -->
					</div>
				
				
            	<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            	
					<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
					<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
					<div class="mb-5">
						<h2 class="tm-block-title">분류</h2>
						<select class="custom-select" id="category" data-cat-num="${itemDTO.category_num}">
							<option value="0">캐릭터</option>
							<option value="1">무기</option>
						</select>
					</div>
					<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
					<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
            	
            	<!-- list 비동기식 조회될 div -->
            	<!-- list 비동기식 조회될 div -->
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						<div id="itemListdiv" class="row justify-content-center">
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
								<div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-overflow">
									<h2 class="tm-block-title">Notification List</h2>
									<div class="tm-notification-items">
									<c:forEach items="${wpList}" var="wpDTO">
										<div class="media tm-notification-item">
											<div class="tm-gray-circle"><img src="/resources/img/character/1. 펭귄-알.gif" width="80" alt="Avatar Image" class="rounded-circle"></div>
											<div class="media-body">
												<p class="mb-2"><b>Jessica</b> and <b>6 others</b> sent you new
												<a href="#"class="tm-notification-link">product updates</a>. Check new orders.</p>
												<span class="tm-small tm-text-color-secondary">6h ago.</span>
											</div>
										</div>
									</c:forEach>
									</div>
								</div>
							</div>
							</div>
							</div>
						</div>
					</div>
				</div>
				<!-- list 비동기식 조회될 div -->
				<!-- list 비동기식 조회될 div -->
            	
            	
    		</div>
		</div>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	
	<script src="/resources/js/store/storelist.js"></script>
</body>
</html>
