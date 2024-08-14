<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>ResultPW</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
				<h1 class="text-white mt-5 mb-5">입력한 아이디의 패스워드 입니다</h1>
            	<div class="container mt-5">
					<div class="row tm-content-row">
					  <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						<div class="tm-bg-primary-dark tm-block tm-block-products">
							<div class="tm-product-table-container">
							<table class="table table-hover tm-table-small tm-product-table">
							  <thead>
								<tr>
								  <th scope="col"></th>
								  <th scope="col">아이디</th>
								  <th scope="col">패스워드</th>
								  <th scope="col"></th>
								</tr>
							  </thead>
							  <tbody>	
									<tr>
										<td></td>
										<td>${usersDTO.user_id }</td>
										<td>${usersDTO.user_pw }</td>
										<td><a href="/users/login">로그인 하러 가기!</a></td>
									</tr>
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
</body>
</html>
