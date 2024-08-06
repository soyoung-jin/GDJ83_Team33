<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Item</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="row justify-content-center">
						<h2 class="text-white mt-3 mb-3">
							Add <b>Item</b>
						</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<main class="form-signin w-100 m-auto">
					<div class="col-6 login">
						<form class="form" action="addItem" method="post">
							<div class="mb-2">
							<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
							<select class="custom-select" id="category">
								<option value="0">캐릭터</option>
								<option value="1">무기</option>
							</select>
							</div>
							<div class="form-floating">
								<label for="item_name">이름</label>
								<input type="text" class="form-control" id="item_name" name="item_name">
							</div>
							<div class="form-floating mt-1">
											<label for="item_hp">추가 체력</label>
								<input type="text" class="form-control" id="item_hp" name="item_hp">
							</div>
							<div class="form-floating mt-1">
								<label for="item_atk">추가 공격력</label>
								<input type="text" class="form-control" id="item_atk" name="item_atk">
							</div>
							<div class="form-floating mt-1">
								<label for="item_dod">추가 회피력</label>
								<input type="text" class="form-control" id="item_dod" name="item_dod">
							</div>
							<div class="form-floating mt-1" id="wpdiv">
							</div>
							<div class="form-floating mt-1">
								<label for="item_price">가격</label>
								<input type="text" class="form-control" id="item_price" name="item_price">
							</div>
							<div class="form-floating mt-1">
								<label for="imgFile" class="form-label">이미지</label>
								<br>
								<input type="file" id="imgFile" name="attach">
							</div>
							<div class="mt-3">
								<button class="btn btn-primary w-100 py-2" type="submit">아이템 추가</button>
							</div>
						</form>
					</div>
				</main>  
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
		<script src="/resources/js/addItem.js"></script>
	</div>
</body>
</html>