<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Item List</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
            	<h1 class="text-white mt-5 mb-5">STORE</h1>
            	
            	<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            	<div class="mb-5">
            	<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
            		<h2 class="tm-block-title">분류</h2>
	            	<select class="custom-select" id="category">
	            		<option value="0">캐릭터</option>
	            		<option value="1">무기</option>
	            	</select>
            	</div>
            	
            	
            	<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
	            	<div class="row">
	            	<!-- List<WeaponDTO>에서 DTO 하나씩 꺼내옴 -->
	            	<c:forEach items="${itemList}" var="itemDTO">
	            		<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
		            	<div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 tm-block-col">
							<!-- 카드형 태그 -->
			            	<div class="card h-100" style="max-width:300px">
			            		<!-- 디테일가기위한 a태그 -->
			            	  <a href="itemDetail?item_num=${itemDTO.item_num}">
			            	  	<!-- 카드형 상부 이미지 -->
							  	<img src="/resources/img/character/4.gif" class="card-img-top" alt="...">
							  </a>
							  <div class="card-body">
							  	<!-- 카드 이미지 하단 아이템명, 가격 -->
							    <h5 class="card-title">${itemDTO.item_name}</h5>
							    <p class="card-text">
							    	${itemDTO.item_price} 원
								</p>
							    <a href="#" class="btn btn-primary">구매</a>
							    <a href="#" class="btn btn-info">장바구니</a>
							  </div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
				</div>
            	
            	<!-- 위시리스트에서 사용
            	<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-overflow">
                        <h2 class="tm-block-title">Notification List</h2>
                        <div class="tm-notification-items">
                        <c:forEach items="${wpList}" var="wpDTO">
                            <div class="media tm-notification-item">
                                <div class="tm-gray-circle"><img src="/resources/img/character/1. 펭귄-알.gif" width="80" alt="Avatar Image" class="rounded-circle"></div>
                                <div class="media-body">
                                    <p class="mb-2"><b>Jessica</b> and <b>6 others</b> sent you new <a href="#"
                                            class="tm-notification-link">product updates</a>. Check new orders.</p>
                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                </div>
                            </div>
                        </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         -->
            <!-- row -->
    </div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
	
	<script src="/resources/js/storelist.js"></script>
</body>
</html>
