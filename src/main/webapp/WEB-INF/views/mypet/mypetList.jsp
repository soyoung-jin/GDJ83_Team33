<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Item List</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<h1 class="text-white mt-5 mb-5">내 캐릭터</h1>

					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
							<div class="row justify-content-center">

							<c:forEach items="${list }" var="dto">
								<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
								<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4 tm-block-col">
									<!-- 카드형 태그 -->
									<div class="card h-10">
										<!-- 디테일가기위한 a태그 -->
										<a href="/mypet/petDetail?pet_num=${dto.pet_num }">
											<!-- 카드형 상부 이미지 -->
											<img src="/store/getImage?file_name=${not empty dto.itemFileDTOs[dto.pet_evolution]?dto.itemFileDTOs[dto.pet_evolution].file_name:'default.gif'}"
											 class="card-img-top" alt="...">
										</a>
										<div class="card-body">
											<!-- 카드 이미지 하단 아이템명, 가격 -->
											<h5 class="card-title">이름 ${dto.pet_name }</h5>
											<h5 class="card-title">레벨 ${dto.pet_level }</h5>
											<c:choose>
												<c:when test="${dto.pet_selected == 0 }">
													<button type="button" class="btn btn-primary"
													data-pet-num="${dto.pet_num}">데려가기</button>											
												</c:when>
												<c:otherwise>
													<button type="button" class="del btn-danger">
													함께 모험중!</button>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>							
							</c:forEach>
							</div>
						</div>
					</div>



					<!-- row -->
				</div>
			</div>
		</div>

	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	<script src="/resources/js/users/myPetList.js"></script>
</body>
</html>
