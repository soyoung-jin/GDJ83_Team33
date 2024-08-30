<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Alarm</title>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<c:import url="../template/topbar.jsp"></c:import>
	
	<div class="container">
        <div class="row">
            <div class="col">
				<h1 class="text-white mt-5 mb-5">알림</h1>
            	<div class="container mt-5">
					<div class="row tm-content-row">
					  <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
						
						<div class="tm-bg-primary-dark tm-block tm-block-products">
						<div class="form-group mb-3">
						<!-- 검색기능 태그 -->
						<!-- 검색기능 태그 -->
							<form method="get">
									<div class="row">
									<div class="col-auto">
										<select id="kind" name="kind" class="custom-select mr-sm-2">
											<option value="alarm_sender" ${alarmList[0].kind eq 'alarm_sender' ? 'selected' : ''}>보낸 사람</option>
			              					<option value="alarm_contents" ${alarmList[0].kind eq 'alarm_contents' ? 'selected' : ''}>내용</option>
										</select>
									</div>
									
									<div class="col-sm-5">
										<input name="search" size="20" type="text" class="form-control" id="search" placeholder="검색어를 입력하세요.">
									</div>
									
									
										<input name="user_id" value="${users_info.user_id}" type="hidden" id="alarm_sender" >
									
									
									<div class="col-auto">
										<button type="submit" class="btn btn-primary" >검색</button>
									</div>
									
									</div>
		 					</form>
						</div>
						
							<div class="tm-product-table-container" id="wishdiv">
							<table class="table table-hover tm-table-small tm-product-table">
							  <thead>
								<tr>
								  
								  <th scope="col">번호</th>
								  <th scope="col">보낸 사람</th>
								  <th scope="col">내용</th>
								  <th scope="col">보낸 날짜</th>
								  
								</tr>
							  </thead>
							  <tbody id="checkdiv">
									<c:forEach items="${alarmListAll}" var="list" varStatus="status">
										<tr>
											
											<td>${status.count}</td>
											<td class="tm-product-name">${list.alarm_sender}</td>
											<td>${list.alarm_contents}</td>
											<td>${list.alarm_received_date}</td>
											
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
						  </div>
						  <!-- table container -->
						   
						</div>
					
					  </div>
					  </div>
					</div>
				  </div>
            	
            	
    		</div>
		</div>
	
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	
	<script src="/resources/js/store/wishlist.js"></script>
</body>
</html>
