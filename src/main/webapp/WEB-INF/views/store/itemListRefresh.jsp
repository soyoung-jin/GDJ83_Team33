<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
		<div class="row col-md-12">
    
	            	<!-- List<WeaponDTO>에서 DTO 하나씩 꺼내옴 -->
					<c:forEach items="${itemList}" var="itemDTO">
	            		<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
		            	<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4 tm-block-col">
							<!-- 카드형 태그 -->
			            	<div class="card h-10" >
			            		<!-- 디테일가기위한 a태그 -->
			            		<c:choose>
									<c:when test="${param.category eq 1}">
			            	  			<a href="itemDetail?item_num=${itemDTO.weapon_num}&category=${param.category}">
									</c:when>
			            			<c:otherwise>
			            				<a href="itemDetail?item_num=${itemDTO.character_num}&category=${param.category}">
			            			</c:otherwise>
			            		</c:choose>
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