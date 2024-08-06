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
						By, <b>Admin</b>
					</p>
				</div>
			</div>
			<div class="row ">
				<main class="form-signin w-100 m-auto">
					<div class="col-6 login">
						<form class="form" action="/users/deleteAccount" method="post">
							<h1 class="h3 mb-3 fw-normal">Please Check Password</h1>

							<div class="form-floating">
								<input type="password" class="form-control" id="user_pw"
									name="user_pw" placeholder="Password">
								<label for="floatingInput">비밀번호</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="user_pw2"
									name="user_pw2" placeholder="Re-enter Password">
								<label for="floatingPassword">비밀번호 확인</label>
							</div>

							<button class="btn btn-danger w-100 py-2" type="submit">회원 탈퇴</button>

						</form>
					</div>
				</main>
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
</body>
</html>