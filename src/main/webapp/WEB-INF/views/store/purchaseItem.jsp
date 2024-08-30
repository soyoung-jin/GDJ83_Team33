<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>purchase</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
                <h1 class="text-white mt-5 mb-5">결제목록</h1>
            	<div class="container mt-5">
					<div class="row tm-content-row">
					  <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						<form action="purchaseItem" method="get" id="frm">
						<div class="tm-bg-primary-dark tm-block tm-block-products">
							<div class="tm-product-table-container" id="wishdiv">
							<table class="table table-hover tm-table-small tm-product-table">
							  <thead>
								<tr>
								  <th scope="col"></th>
								  <th scope="col">이름</th>
								  <th scope="col">설명</th>
								  <th scope="col">체력</th>
								  <th scope="col">공격력</th>
								  <th scope="col">회피력</th>
								  <th scope="col">가격</th>
								</tr>
							  </thead>
							  <tbody id="checkdiv">
							  		<c:choose> 
							  			<c:when test="${purchaseList eq null}">
											<tr>
												<td><div class="tm-white-circle" style="text-align: center;">
													<!-- 이미지 리스트 -->
														<div id="carouselExampleIndicators${dto.item_num}" class="carousel slide" data-ride="carousel" data-interval="false">
														  
														  <div class="carousel-inner" >
															<div class="carousel-item active">
															  <img src="getImage?file_name=${not empty dto.itemFileDTOs[0]?dto.itemFileDTOs[0].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
															</div>
															<div class="carousel-item">
															  <img src="getImage?file_name=${not empty dto.itemFileDTOs[1]?dto.itemFileDTOs[1].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
															</div>
															<div class="carousel-item">
															  <img src="getImage?file_name=${not empty dto.itemFileDTOs[2]?dto.itemFileDTOs[2].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
															</div>
															<div class="carousel-item">
															  <img src="getImage?file_name=${not empty dto.itemFileDTOs[3]?dto.itemFileDTOs[3].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
															</div>
														  </div>
														<c:if test="${dto.category_num eq 0}">
															  <a class="carousel-control-prev atime" type="button" data-target="#carouselExampleIndicators${dto.item_num}" data-slide="prev">
																<span class="carouselIcon" aria-hidden="true"><img src="getImage?file_name=arrow-pre.png" width="10"></span>
																<!-- <span class="sr-only">Previous</span -->
															  </a>
															  
															  <a class="carousel-control-next atime" type="button" data-target="#carouselExampleIndicators${dto.item_num}" data-slide="next">
																<span class="carouselIcon" aria-hidden="true"><img src="getImage?file_name=arrow-next.png" width="10"></span>
																<!-- <span class="sr-only">Next</span> -->
															  </a>
														</c:if>
														</div></div></td>
												<td class="tm-product-name itemName" id="${dto.item_num}">${dto.item_name}</td>
												<td>${dto.item_description}</td>
												<td>${dto.item_hp}</td>
												<td>${dto.item_atk}</td>
												<td>${dto.item_dod}</td>
												<td class="itemPrice" id="${dto.item_price}">${dto.item_price}</td>
											</tr>
							  			</c:when>
							  			<c:otherwise>
											<c:forEach items="${purchaseList}" var="list">
												<tr>
													<td><div class="tm-white-circle" style="text-align: center;">
												<!-- 이미지 리스트 -->
													<div id="carouselExampleIndicators${list.itemDTO.item_num}" class="carousel slide" data-ride="carousel" data-interval="false">
													  
													  <div class="carousel-inner" >
													    <div class="carousel-item active">
													      <img src="getImage?file_name=${not empty list.itemDTO.itemFileDTOs[0]?list.itemDTO.itemFileDTOs[0].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
													    </div>
													    <div class="carousel-item">
													      <img src="getImage?file_name=${not empty list.itemDTO.itemFileDTOs[1]?list.itemDTO.itemFileDTOs[1].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
													    </div>
													    <div class="carousel-item">
													      <img src="getImage?file_name=${not empty list.itemDTO.itemFileDTOs[2]?list.itemDTO.itemFileDTOs[2].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
													    </div>
													    <div class="carousel-item">
													      <img src="getImage?file_name=${not empty list.itemDTO.itemFileDTOs[3]?list.itemDTO.itemFileDTOs[3].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle">
													    </div>
													  </div>
													<c:if test="${list.itemDTO.category_num eq 0}">
														  <a class="carousel-control-prev atime" type="button" data-target="#carouselExampleIndicators${list.itemDTO.item_num}" data-slide="prev">
														    <span class="carouselIcon" aria-hidden="true"><img src="getImage?file_name=item/arrow-pre.png" width="10"></span>
														    <!-- <span class="sr-only">Previous</span -->
														  </a>
														  
														  <a class="carousel-control-next atime" type="button" data-target="#carouselExampleIndicators${list.itemDTO.item_num}" data-slide="next">
														    <span class="carouselIcon" aria-hidden="true"><img src="getImage?file_name=arrow-next.png" width="10"></span>
														    <!-- <span class="sr-only">Next</span> -->
														  </a>
													</c:if>
													</div></div></td>
													<td class="tm-product-name itemName" id="${list.itemDTO.item_num}" data-wnum="${list.wishlist_num}" data-iname="${list.itemDTO.item_name}">${list.itemDTO.item_name}</td>
													<td>${list.itemDTO.item_description}</td>
													<td>${list.itemDTO.item_hp}</td>
													<td>${list.itemDTO.item_atk}</td>
													<td>${list.itemDTO.item_dod}</td>
													<td class="itemPrice" id="${list.itemDTO.item_price}">${list.itemDTO.item_price}</td>
												</tr>
											</c:forEach>
							  			</c:otherwise>
							  		</c:choose>
								</tbody>
							</table>
						  </div>
						  <!-- table container -->
						  <button type="button" id="kakaobtn">카카오페이</button>
						</div>
					</form>
					  </div>
					  </div>
					</div>

 

                
            </div>
        </div>
            <!-- row -->
    </div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
    <script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
    <script src="/resources/js/store/purchaseItem.js"></script>
</body>
</html>