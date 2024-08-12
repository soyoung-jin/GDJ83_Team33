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
				<h1 class="text-white mt-5 mb-5">WISHLIST</h1>
            	<div class="container mt-5">
					<div class="row tm-content-row">
					  <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						<div class="tm-bg-primary-dark tm-block tm-block-products">
							<div class="tm-product-table-container" id="delwish">
							<table class="table table-hover tm-table-small tm-product-table">
							  <thead>
								<tr>
								  <th scope="col"><input type="checkbox" /></th>
								  <th scope="col"></th>
								  <th scope="col">이름</th>
								  <th scope="col">설명</th>
								  <th scope="col">체력</th>
								  <th scope="col">공격력</th>
								  <th scope="col">회피력</th>
								  <th scope="col">가격</th>
								  <th scope="col"><a href="#" class="tm-product-delete-link">
									  <i class="far fa-trash-alt tm-product-delete-icon"></i>
									</a></th>
								</tr>
							  </thead>
							  <tbody>
									<c:forEach items="${wishlist}" var="list">
										<tr>
											<td scope="row"><input type="checkbox"/></td>
											<td><div class="tm-gray-circle"><img src="/resources/img/character/4.gif" width="80" alt="Avatar Image" class="rounded-circle"></div></td>
											<td class="tm-product-name">${list.itemDTO.item_name}</td>
											<td>${list.itemDTO.item_description}</td>
											<td>${list.itemDTO.item_hp}</td>
											<td>${list.itemDTO.item_atk}</td>
											<td>${list.itemDTO.item_dod}</td>
											<td>${list.itemDTO.item_price}</td>
											<td>
												<a class="tm-product-delete-link delbtn">
												<i class="far fa-trash-alt tm-product-delete-icon" data-wnum="${list.wishlist_num}"></i>
												</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						  </div>
						  <!-- table container -->
						  <a href="add-product.html"
							class="btn btn-primary mb-3">구매하기</a>
						  <button class="btn btn-primary">
							선물하기
						  </button>
						</div>
					  </div>
					  </div>
					</div>
				  </div>
            	
            	
    		</div>
		</div>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	
	<script src="/resources/js/store/wishlist.js"></script>
</body>
</html>
