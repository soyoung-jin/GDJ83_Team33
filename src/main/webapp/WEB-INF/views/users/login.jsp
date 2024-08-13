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
						<form class="form" action="/users/login" method="post">
							<h1 class="h3 mb-3 fw-normal">Please Sign In</h1>

							<div class="form-floating">
								<input type="text" class="form-control" id="user_id"
									name="user_id" value="${remember }" placeholder="User ID">
								<label for="user_id">아이디</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="user_pw"
									name="user_pw" placeholder="Password">
								<label for="user_pw">비밀번호</label>
							</div>

							<div class="form-check text-start my-3">
								<input id="flexCheckDefault" class="form-check-input"
									type="checkbox" name="remember" checked>
								<label class="form-check-label" for="flexCheckDefault">아이디 저장</label>
								<a href="/users/findID" class="col-lg-3">아이디 찾기</a>
								<a href="#" class="col-lg-3">비밀번호 찾기</a>
							</div>
							
							<button class="btn btn-primary w-100 py-2" type="submit">로그인</button>

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