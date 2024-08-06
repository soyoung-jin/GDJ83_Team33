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
	
	<div class="container">
        <div class="row">
            <div class="col">
                <h1 class="text-white mt-5 mb-5">Item Detail</h1>
                <img alt="" width="300" src="/resources/img/character/4.gif">
				<table class="table">
					<thead>
						<tr>
							<th>이름</th>
							<th>추가 체력</th>
							<th>추가 공격력</th>
							<th>추가 회피력</th>
							<c:if test="${param.category == 1}">
								<th>무기 설명</th>	
							</c:if>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${itemDTO.item_name}</td>
							<td>${itemDTO.item_hp}</td>
							<td>${itemDTO.item_atk}</td>
							<td>${itemDTO.item_dod}</td>
							<c:if test="${param.category == 1}">
								<td>${itemDTO.weapon_description}</td>
							</c:if>
							<td>${itemDTO.item_price}</td>
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