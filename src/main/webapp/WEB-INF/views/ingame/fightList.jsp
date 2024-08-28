<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Wish List</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
				<h1 class="text-white mt-5 mb-5">전적리스트</h1>
            	<div class="container mt-5">
					<div class="row tm-content-row">
					  <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						
						<div class="tm-bg-primary-dark tm-block tm-block-products">
							<div class="tm-product-table-container" id="wishdiv">
							<table class="table table-hover tm-table-small tm-product-table">
							  <thead>
								<tr>
								  
								  
								  <th scope="col">상대 이름</th>
								  <th scope="col">게임 결과</th>
								  <th scope="col">게임한 날</th>
								  
								</tr>
							  </thead>
							  <tbody id="checkdiv">
									<c:forEach items="${list}" var="list">
										<tr>
											
											
											<td class="tm-product-name">${list.enemy_user_id}</td>
											<c:choose>
												<c:when test="${list.record_outcome eq 0}">
													<td>패배</td>
												</c:when>
												<c:when test="${list.record_outcome eq 1}">
													<td>승리</td>
												</c:when>
												<c:otherwise>
													<td>동점</td>
												</c:otherwise>
											</c:choose>
											<td>${list.record_date}</td>
											
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
						  </div>
						  <!-- table container -->
						   
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
