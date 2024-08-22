<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<c:import url="../template/header.jsp"></c:import>
	<style type="text/css">
		.imgSize {
			height: 270px;
		}
	
	</style>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
		        <a class="btn btn-primary" href="updateItem?item_num=${dto.item_num}">수정</a>
	            <a class="btn btn-primary" href="deleteItem?item_num=${dto.item_num}">삭제</a>
        <div class="row">
            <div class="col">
                <h1 class="text-white mt-5 mb-5">Item Detail</h1>
                <div class="row justify-content-center">
                <c:forEach begin="0" end="${dto.category_num==0?'3':'0'}" step="1" var="i">
                	<div class="${dto.category_num==0?'col':'col-3'}">
		                <div class="card">
						  <img src="getImage?file_name=${not empty dto.itemFileDTOs[i]?dto.itemFileDTOs[i].file_name:'default.gif'}" class="card-img-top imgSize" alt="아이템 이미지">
						  <div class="card-body">
							  <c:choose>
							  	<c:when test="${i==0}">
							  		<h5 class="card-title">${dto.category_num==0?'알':''}</h5>		  	
							  	</c:when>
							  	<c:when test="${i==1}">
							  		<h5 class="card-title">성장기</h5>		  	
							  	</c:when>
							  	<c:when test="${i==2}">
							  		<h5 class="card-title">반항기</h5>		  	
							  	</c:when>
							  	<c:when test="${i==3}">
							  		<h5 class="card-title">으른</h5>		  	
							  	</c:when>
							  </c:choose>
						  </div>
						</div>
					</div>
				</c:forEach>
				</div>
				<table class="table">
					<thead>
						<tr>
						<c:choose>
							<c:when test="${dto.category_num == 0}">
								<th>종족</th>
							</c:when>
							<c:otherwise>
								<th>무기이름</th>
							</c:otherwise>
						</c:choose>
							<th>추가 체력</th>
							<th>추가 공격력</th>
							<th>추가 회피력</th>
							<th>무기 설명</th>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${dto.item_name}</td>
							<td>${dto.item_hp}</td>
							<td>${dto.item_atk}</td>
							<td>${dto.item_dod}</td>
							<td>${dto.item_description}</td>
							<td>${dto.item_price}</td>
						</tr>
					</tbody>
				</table>
            </div>
        </div>
            <!-- row -->
    </div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
</body>
</html>