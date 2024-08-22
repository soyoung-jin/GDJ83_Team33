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
					<p class="text-white mt-5 mb-5"></p>
				</div>
			</div>
			<div class="row ">
				<main class="form-signin w-100 m-auto">
					<div class="col-6 login">
						<form class="form" action="/users/changePW" method="post">
							<h1 class="h3 mb-3 fw-normal">Change Password!!</h1>

							<div class="form-floating">
								<input type="password" class="form-control" id="user_pw"
									name="user_pw" placeholder="현재 비밀번호">
								<label for="user_pw">현재 비밀번호</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="new_pw"
									name="new_pw" placeholder="새 비밀번호 입력">
								<label for="new_pw">새 비밀번호</label>
								<div id="error-message"></div>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="new_pw2"
									name="new_pw2" placeholder="새 비밀번호 입력">
								<label for="new_pw2">새 비밀번호 확인</label>
								<div id="error-message2"></div>
							</div>

							<button id = "btn" class="btn btn-primary w-100 py-2" type="button">비밀번호 변경</button>

						</form>
					</div>
				</main>
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
		<script src="/resources/js/users/changePW.js"></script>
	</div>
</body>
</html>