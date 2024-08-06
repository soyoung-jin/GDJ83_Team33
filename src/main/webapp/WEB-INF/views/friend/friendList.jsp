<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<p class="text-white mt-5 mb-5">
						Welcome, <b>Admin</b>
					</p>
				</div>
			</div>
			<div class="row gx-5 justify-content-center">
				<!-- Pricing card free-->
				<c:forEach items="${usersDTO.friendDTO}" var="fDTO">
					<div class="col-lg-6 col-xl-4 mb-5">
						<div class="card mb-5">
							<div class="card-body p-5">
								<div class="small text-uppercase fw-bold text-muted">${fDTO.friend_num}</div>
								<div>
									<img alt="tamagochi" src="/resources/img/tama.gif">
								</div>
								<div class="mb-3">
									<span class="display-5 fw-bold">${fDTO.friend_id}</span> 
								</div>
								<div class="d-grid">
									<a class="btn btn-outline-secondary"
										href="./friendDetail?user_id=${fDTO.user_id}&friend_id=${fDTO.friend_id}">자세히 보기</a>
								</div>
							</div>
						</div>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
</body>
</html>
