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
						<b>아이디 찾기</b>
					</p>
				</div>
			</div>
			<div class="row ">
				<main class="form-signin w-100 m-auto">
					<div class="col-6 login">
						<form class="form" action="/users/findID" method="post">
							<h1 class="h3 mb-3 fw-normal">아이디를 잊어버리셨나요? 유감이에요</h1>

							<div class="form-floating">
								<input type="text" class="form-control" id="user_name"
									name="user_name" placeholder="">
								<label for="user_name">이름</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="user_email"
									name="user_email" placeholder="">
								<label for="user_email">이메일</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="user_phone"
									name="user_phone" placeholder="">
								<label for="user_phone">전화번호</label>
							</div>
							
							<button class="btn btn-primary w-100 py-2" type="submit">아이디 찾기</button>

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