<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
		<c:import url="../template/topbar.jsp"></c:import>


		<div class="container mt-5">
			<div class="row tm-content-row">
				<div class="col-12 tm-block-col">
					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<h2 class="tm-block-title">내 캐릭터 정보</h2>
						<p class="text-white">캐릭터 선택</p>
						<select class="custom-select">
						<c:forEach items="${list }" var="dto">
							<option value="${dto.pet_num }">${dto.pet_name }</option>						
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<!-- row -->
			<div class="row tm-content-row">
				<div class="tm-block-col tm-col-avatar">
					<div class="tm-bg-primary-dark tm-block tm-block-avatar">
						<h2 class="tm-block-title">캐릭터 이름</h2>
						<input name="name" value="${myPetDTO.pet_name }" type="text" class="form-control validate" />
						<div class="tm-avatar-container">
							<img src="/resources/img/character/4.gif" alt="Avatar"
								class="tm-avatar img-fluid mb-4" />
						</div>
						<button class="btn btn-primary btn-block text-uppercase">
							캐릭터 이름 수정</button>
					</div>
				</div>
				<div class="tm-block-col tm-col-account-settings">
					<div class="tm-bg-primary-dark tm-block tm-block-settings">
						<h2 class="tm-block-title">Account Settings</h2>
						<form action="" class="tm-signup-form row">
							<div class="form-group col-lg-6">
								<label for="name">Account Name</label> <input id="name"
									name="name" type="text" class="form-control validate" />
							</div>
							<div class="form-group col-lg-6">
								<label for="email">Account Email</label> <input id="email"
									name="email" type="email" class="form-control validate" />
							</div>
							<div class="form-group col-lg-6">
								<label for="password">Password</label> <input id="password"
									name="password" type="password" class="form-control validate" />
							</div>
							<div class="form-group col-lg-6">
								<label for="password2">Re-enter Password</label> <input
									id="password2" name="password2" type="password"
									class="form-control validate" />
							</div>
							<div class="form-group col-lg-6">
								<label for="phone">Phone</label> <input id="phone" name="phone"
									type="tel" class="form-control validate" />
							</div>
							<div class="form-group col-lg-6">
								<label class="tm-hide-sm">&nbsp;</label>
								<button type="submit"
									class="btn btn-primary btn-block text-uppercase">
									Update Your Profile</button>
							</div>
							<div class="col-12">
								<button type="submit"
									class="btn btn-primary btn-block text-uppercase">
									Delete Your Account</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- row -->
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
</body>
</html>