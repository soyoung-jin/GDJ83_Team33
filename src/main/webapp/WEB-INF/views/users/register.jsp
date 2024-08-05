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
						<form class="form" action="/users/register" method="post">
							<h1 class="h3 mb-3 fw-normal">Please Register</h1>

							<div class="form-floating">
								<input type="text" class="form-control" id="floatingInput"
								name="user_id">
								<label for="floatingInput">User ID</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="floatingPassword"
								name="user_pw">
								<label for="floatingPassword">Password</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="floatingInput"
								name="user_name">
								<label for="floatingInput">User Name</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="floatingInput"
								name="user_nickname">
								<label for="floatingInput">User NickName</label>
							</div>
							<div class="form-floating">
								<input type="text" class="form-control" id="floatingInput"
								name="user_phone">
								<label for="floatingInput">Phone Number</label>
							</div>
							<div class="form-floating">
								<input type="email" class="form-control" id="floatingInput"
								name="user_email" placeholder="name@example.com">
								<label for="floatingInput">Email</label>
							</div>
							
							<button class="btn btn-primary w-100 py-2" type="submit">Let's Register!!</button>

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