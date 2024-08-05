<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Item List</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="pixelify-sans-font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
            	<h1 class="text-white mt-5 mb-5">Item List</h1>
				<table border="1">
					<thead>
						<tr>
							<th>무기 번호</th>
							<th>무기 이름</th>
							<th>추가 체력</th>
							<th>추가 공격력</th>
							<th>추가 회피력</th>
							<th>무기 설명</th>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${wpList}" var="wpDTO">
							<tr>
								<td>${wpDTO.weapon_num}</td>
								<td>${wpDTO.weapon_name}</td>
								<td>${wpDTO.weapon_hp}</td>
								<td>${wpDTO.weapon_atk}</td>
								<td>${wpDTO.weapon_dod}</td>
								<td>${wpDTO.weapon_description}</td>
								<td>${wpDTO.weapon_price}</td>
							</tr>
						</c:forEach>
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
