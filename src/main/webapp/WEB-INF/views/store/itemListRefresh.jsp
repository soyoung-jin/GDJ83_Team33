<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   


		<div class="row col-12">
	        <!-- List<WeaponDTO>에서 DTO 하나씩 꺼내옴 -->
			<c:forEach items="${itemList}" var="itemDTO">
				<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
				<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4 tm-block-col">
					<!-- 카드형 태그 -->
					<div class="card h-10" >
						<!-- 이미지 리스트 -->
						<div id="carouselExampleIndicators${itemDTO.item_num}" class="carousel slide" data-ride="carousel" data-interval="false">
						  <ol class="carousel-indicators">
						    <li data-target="#carouselExampleIndicators${itemDTO.item_num}" data-slide-to="0" class="active"></li>
						    <li data-target="#carouselExampleIndicators${itemDTO.item_num}" data-slide-to="1"></li>
						    <li data-target="#carouselExampleIndicators${itemDTO.item_num}" data-slide-to="2"></li>
						    <li data-target="#carouselExampleIndicators${itemDTO.item_num}" data-slide-to="3"></li>
						  </ol>
						  <div class="carousel-inner">
						  <a href="itemDetail?item_num=${itemDTO.item_num}" onmouseover="detailModal()">
						    <div class="carousel-item active">
						      <img src="getImage?file_name=${not empty itemDTO.itemFileDTOs[0]?itemDTO.itemFileDTOs[0].file_name:'default.gif'}" class="d-block w-100 imgSize" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="getImage?file_name=${not empty itemDTO.itemFileDTOs[1]?itemDTO.itemFileDTOs[1].file_name:'default.gif'}" class="d-block w-100 imgSize" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="getImage?file_name=${not empty itemDTO.itemFileDTOs[2]?itemDTO.itemFileDTOs[2].file_name:'default.gif'}" class="d-block w-100 imgSize" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="getImage?file_name=${not empty itemDTO.itemFileDTOs[3]?itemDTO.itemFileDTOs[3].file_name:'default.gif'}" class="d-block w-100 imgSize" alt="...">
						    </div>
						   </a>
						  </div>
						  <c:if test="${itemDTO.category_num eq 0}">
							  <a class="carousel-control-prev atime" type="button" data-target="#carouselExampleIndicators${itemDTO.item_num}" data-slide="prev">
							    <span class="carouselIcon" aria-hidden="true"><img src="/resources/img/item/arrow-pre.png"></span>
							    <!-- <span class="sr-only">Previous</span -->
							  </a>
							  
							  <a class="carousel-control-next atime" type="button" data-target="#carouselExampleIndicators${itemDTO.item_num}" data-slide="next">
							    <span class="carouselIcon" aria-hidden="true"><img src="/resources/img/item/arrow-next.png"></span>
							    <!-- <span class="sr-only">Next</span> -->
							  </a>
							</c:if>
						</div>
						<!-- 이미지 리스트 -->
					
						<div class="card-body">
							<!-- 카드 이미지 하단 아이템명, 가격 -->
							<h5 class="card-title">${itemDTO.item_name}</h5>
							<p class="card-text">
								${itemDTO.item_price} 원
							</p>
							<a type="button" class="btn btn-info purchaseItem" data-inum="${itemDTO.item_num}">구매</a>
							<a type="button" class="btn btn-info addwish" data-inum="${itemDTO.item_num}">장바구니</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
 
			<!-- 페이징 -->
			<!-- 페이징 -->
		<div class="row col-12">
			<div class="container">
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
		</div>
		</div>
			<!-- /페이징 -->
			<!-- /페이징 -->

