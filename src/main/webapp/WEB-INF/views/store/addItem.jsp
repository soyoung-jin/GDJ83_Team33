<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add Item</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="row justify-content-center">
						<h2 class="text-white mt-3 mb-3">
							${dto eq null?'ADD':'Update'} <b>Item</b>
						</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<main class="form-signin w-100 m-auto">
					<div class="col-6 login" id="add">
						<form class="form" action="${dto eq null?'addItem':'updateItem'}" method="post" enctype="multipart/form-data">
							<div class="mb-2">
								<!-- 캐릭터, 무기 분류별로 조회하기 위한 셀렉트 태그 -->
								<c:choose>
									<c:when test="${dto eq null}">
										<select class="custom-select" id="category_num" name="category_num">
											<option value="0">캐릭터</option>
											<option value="1">무기</option>
										</select>
									</c:when>
									<c:otherwise>
										<input type="hidden" id="category_num" name="category_num" value="${dto.category_num}">
									</c:otherwise>
								</c:choose>
							</div>
							
							<!-- update 때 item num으로 수정할 아이템 번호 찾아가야함 -->
							<input type="hidden" name="item_num" value="${dto.item_num}">
							
							<div class="form-floating">
								<label for="name" id="chname">이름</label>
								<input type="text" class="form-control" id="name" name="item_name" value="${dto.item_name}">
								<div id="name_error"></div>
							</div>
							<div class="form-floating mt-1">
								<label for="description">설명</label>
								<input type="text" class="form-control" id="description" name="item_description" value="${dto.item_description}">
								<div id="description_error"></div>
							</div>
							<div class="form-floating mt-1">
								<label for="hp">추가 체력</label>
								<input type="text" class="form-control" id="hp" name="item_hp" value="${dto.item_hp}">
								<div id="hp_error"></div>
							</div>
							<div class="form-floating mt-1">
								<label for="atk">추가 공격력</label>
								<input type="text" class="form-control" id="atk" name="item_atk" value="${dto.item_atk}">
								<div id="atk_error"></div>
							</div>
							<div class="form-floating mt-1">
								<label for="dod">추가 회피력</label>
								<input type="text" class="form-control" id="dod" name="item_dod" value="${dto.item_dod}">
								<div id="dod_error"></div>
							</div>
							<div class="form-floating mt-1">
								<label for="price">가격</label>
								<input type="text" class="form-control" id="price" name="item_price" value="${dto.item_price}">
								<div id="price_error"></div>
							</div>
							<div class="form-floating mt-1" id="fileUpload">
								<c:if test="${dto eq null}">
									<label class="form-label">기본 이미지</label>
									<input class="fileList" type="file" name="attach">
									<label class="form-label">2단계 이미지</label>
									<input class="fileList" type="file" name="attach">
									<label class="form-label">3단계 이미지</label>
									<input class="fileList" type="file" name="attach">
									<label class="form-label">4단계 이미지</label>
									<input class="fileList" type="file" name="attach">
								</c:if>
							</div>
							<div>
								<c:if test="${dto ne null}">
									<label class="form-label">기본 이미지</label>
									<input type="file" name="attach">
									<div class="tm-gray-circle"><img src="getImage?file_name=${dto.itemFileDTOs[0] ne null?dto.itemFileDTOs[0].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle"></div>
									<c:if test="${dto.category_num == 0}">
										<label class="form-label">2단계 이미지</label>
										<input class="fileList" type="file" name="attach">
										<div class="tm-gray-circle"><img src="getImage?file_name=${dto.itemFileDTOs[1] ne null?dto.itemFileDTOs[1].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle"></div>
										<label class="fileList" class="form-label">3단계 이미지</label>
										<input class="fileList" type="file" name="attach">
										<div class="tm-gray-circle"><img src="getImage?file_name=${dto.itemFileDTOs[2] ne null?dto.itemFileDTOs[2].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle"></div>
										<label class="form-label">4단계 이미지</label>
										<input class="fileList" type="file"  name="attach">
										<div class="tm-gray-circle"><img src="getImage?file_name=${dto.itemFileDTOs[3] ne null?dto.itemFileDTOs[3].file_name:'default.gif'}" width="80" alt="Avatar Image" class="rounded-circle"></div>
									</c:if>
								</c:if>
							</div>
							<div class="mt-3">
								<button class="btn btn-primary w-100 py-2" type="submit" id="btn"> ${dto eq null?'아이템 추가':'아이템 수정'} </button>
							</div>
						</form>
					</div>
				</main>  
			</div>
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
		<script src="/resources/js/store/addItem.js"></script>
</body>
</html>