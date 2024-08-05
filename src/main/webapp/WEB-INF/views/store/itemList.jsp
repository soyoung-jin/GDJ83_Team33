<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Item List</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="pixelify-sans-font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
            	<h1 class="text-white mt-5 mb-5">STORE</h1>
            	<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
            	<div class="row">
            	<c:forEach items="${wpList}" var="wpDTO">
            	<div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 tm-block-col">
            	<div class="card h-100" style="width: max-width: 300px;">
				  <img src="/resources/img/character/1. 펭귄-알.gif" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">${wpDTO.weapon_name}</h5>
				    <p class="card-text">
				    ${wpDTO.weapon_description}
				    <br>
				    ${wpDTO.weapon_price} 원
					</p>
				    <a href="#" class="btn btn-primary">구매</a>
				    <a href="#" class="btn btn-info">장바구니</a>
				  </div>
				</div>
				</div>
				</c:forEach>
				</div>
				</div>
            	
            	
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
	            	
	            	<div class="tm-product-table-container">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">무기 번호</th>
								<th scope="col">무기 이름</th>
								<th scope="col">추가 체력</th>
								<th scope="col">추가 공격력</th>
								<th scope="col">추가 회피력</th>
								<th scope="col">무기 설명</th>
								<th scope="col">가격</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${wpList}" var="wpDTO">
								<tr scope="row">
									<td>${wpDTO.weapon_num}</td>
									<td><a href="./itemDetail?weapon_num=${wpDTO.weapon_num}">${wpDTO.weapon_name}</a></td>
									<td>${wpDTO.weapon_hp}</td>
									<td>${wpDTO.weapon_atk}</td>
									<td>${wpDTO.weapon_dod}</td>
									<td>${wpDTO.weapon_description}</td>
									<td>${wpDTO.weapon_price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
            </div>
        </div>
            <!-- row -->
    </div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
</body>
</html>
