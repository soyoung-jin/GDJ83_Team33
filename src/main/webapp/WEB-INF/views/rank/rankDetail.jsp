<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<c:import url="../template/header.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/boardSY.css">
</head>
<body id="reportsPage" class="font">
	
		<c:import url="../template/topbar.jsp"></c:import>
<div class="container">
<div class="row">
	<div class="col">
				<h3 class="text-white mt-5 mb-5">${myPetDTO.user_id}님의 캐릭터 정보</h3>
		<div class="container mt-5">		
					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">

			<!-- row -->
			<div class="row tm-content-row">
				<div class="tm-block-col tm-col-avatar">
					<div class="tm-bg-primary-dark tm-block tm-block-avatar">
						<form action="/mypet/updateName" method="post" class="tm-signup-form row">
							<h2 class="tm-block-title">캐릭터 이름</h2>
							<input name="pet_name" value="${myPetDTO.pet_name }" type="text"
								class="form-control validate" />
							<input id="pet_num" name="pet_num" value="${myPetDTO.pet_num }" type="hidden"/>
							<div class="tm-avatar-container">
								<img src="/resources/img/character/4.gif" alt="Avatar"
									class="tm-avatar img-fluid mb-4" />
							</div>
							
						</form>
					</div>
				</div>
				<div class="tm-block-col tm-col-account-settings">
					<div class="tm-bg-primary-dark tm-block tm-block-settings">
						<h2 class="tm-block-title">캐릭터 정보</h2>
						<form action="" class="tm-signup-form row">
							<div class="form-group col-lg-6">
								<label for="pet_spc">종족</label>
								<input id="pet_spc" name="pet_spc" value="${myPetDTO.pet_spc }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_level">레벨</label>
								<input id="pet_level" name="pet_level" value="${myPetDTO.pet_level }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_exp">경험치</label>
								<input id="pet_exp" name="pet_exp" value="${myPetDTO.pet_exp }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_hp">체력</label>
								<input id="pet_hp" name="pet_hp" value="${myPetDTO.pet_hp }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_atk">공격력</label>
								<input id="pet_atk" name="pet_atk" value="${myPetDTO.pet_atk }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_dod">회피력</label>
								<input id="pet_dod" name="pet_dod" value="${myPetDTO.pet_dod }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_pop">인기도</label>
								<input id="pet_pop" name="pet_pop" value="${myPetDTO.pet_pop }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							<div class="form-group col-lg-6">
								<label for="pet_hungry">포만감</label>
								<input id="pet_hungry" name="pet_hungry" value="${myPetDTO.pet_hungry }"
									type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
							</div>
							
							<c:forEach items="${usersDTO.friendDTO}" var="friendList">
							<c:choose>
								<c:when test="${myPetDTO.user_id == friendList.friend_id}">
								<a href="../friend/friendDetail?friend_num=${friendList.friend_num}" id="friendDetail" class="btn btn-outline-warning mb-3">친구보기</a>
								</c:when>
								
								<c:when test="${myPetDTO.user_id == friendList.user_id}">
								<input class="userId" value="${friendList.user_id}"
									type="hidden">
								</c:when>
								
								
							</c:choose>
							</c:forEach>
							
								<a href="/friend/makeFriend?user_id=${myPetDTO.user_id}&pet_num=${myPetDTO.pet_num}" data-user-id="${myPetDTO.user_id}" id="makeFriendBtn" class="btn btn-outline-success mb-3">친구추가</a>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- row -->
	</div>
	</div>
	</div>
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	<script type="text/javascript">
	const userId = "${users_info.user_id}"
	</script>
	<script src="/resources/js/users/selectPetDetail.js"></script>
	<script src="/resources/js/rank/rankDetail.js"></script>
</body>
</html>