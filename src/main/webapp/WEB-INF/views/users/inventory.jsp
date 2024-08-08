<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Item List</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>

	<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="text-white mt-5 mb-5">내 아이템</h1>

				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						<div class="row justify-content-center">

							<c:forEach items="${list }" var="dto">
								<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
								<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4 tm-block-col">
									<!-- 카드형 태그 -->
									<div class="card h-10">
										<!-- 카드형 상부 이미지 -->
										<img src="/resources/img/character/4.gif" class="card-img-top"
											alt="...">
										<div class="card-body">
											<!-- 카드 이미지 하단 아이템명, 가격 -->
											<h5 class="card-title">${dto.item_name }</h5>
											<h5 class="card-title">${dto.item_description }</h5>
											<h5 class="card-title">체력 증가 : ${dto.item_hp }</h5>
											<h5 class="card-title">공격력 증가 : ${dto.item_atk }</h5>
											<h5 class="card-title">회피력 증가 : ${dto.item_dod }</h5>
											<a href="#" class="btn btn-primary">장착</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- row -->

	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
