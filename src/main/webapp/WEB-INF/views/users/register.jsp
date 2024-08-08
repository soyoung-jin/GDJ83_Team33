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
			<div class="row ">
				<main class="form-signin w-100 m-auto">
					<div class="col-6 login">
						<form class="form" action="/users/register" method="post" id="form">
							<h1 class="h3 mb-3 fw-normal">Please Register</h1>

							<div class="form-floating">
								<input type="text" class="form-control" id="user_id"
								name="user_id">
								<label for="user_id">아이디</label>
								<div id="duplicate-check"></div>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="user_pw"
								name="user_pw">
								<label for="user_pw">비밀번호</label>
								<div id="length-check"></div>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="user_pw2">
								<label for="user_pw2">비밀번호 확인</label>
								<div id="error-message"></div>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="user_name"
								name="user_name">
								<label for="user_name">이름</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="user_nickname"
								name="user_nickname">
								<label for="user_nickname">닉네임</label>
							</div>
							<div class="form-floating">
								<input type="tel" class="form-control" id="user_phone"
								name="user_phone">
								<label for="user_phone">전화 번호</label>
							</div>
							<div class="form-floating">
								<input type="email" class="form-control" id="user_email"
								name="user_email" placeholder="name@example.com">
								<label for="user_email">이메일</label>
							</div>
							
							<button id="blankCheck" class="btn btn-primary w-100 py-2" type="button">회원 가입</button>

						</form>
					</div>
				</main>
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
	<script src="/resources/js/users/register.js"></script>
</body>
</html>