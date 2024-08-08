<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
		<div class="row">
	        <!-- List<WeaponDTO>에서 DTO 하나씩 꺼내옴 -->
			<c:forEach items="${itemList}" var="itemDTO">
				<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
				<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4 tm-block-col">
					<!-- 카드형 태그 -->
					<div class="card h-10" >
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
							<button type="button" class="btn btn-info addwish" data-inum="${itemDTO.item_num}">장바구니</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

			<!-- 페이징 -->
			<!-- 페이징 -->
			<div class="row justify-content-center" id="paging">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
					<li class="page-item ${pager.pre?'':'disabled'}"><a class="page-link" id="${pager.startNum-1}" >Previous</a></li>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
						<li class="page-item"><a class="page-link pagenum" data-num="${i}">${i}</a></li>
					</c:forEach>
					<li class="page-item ${pager.next?'':'disabled'}"><a class="page-link" id="${pager.lastNum+1}">Next</a></li>
					</ul>
				</nav>
			</div>
			<!-- /페이징 -->
			<!-- /페이징 -->