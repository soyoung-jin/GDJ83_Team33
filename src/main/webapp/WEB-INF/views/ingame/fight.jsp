<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="/resources/css/fight.css">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	<div id="fightBtnParent" class="mt-2">
		<a id="fightBtn" href="#">
			<img src="/resources/img/ingame/fight.png" alt="">
		</a>
	</div>
	<p id="clickMe">클릭해주세요</p>
	
			<!-- 캐릭터 상태&기본행위 메뉴 -->
		<div class="container">
			<div id="petParent">
				<%-- <img src="getImage?file_name=${itemDTO.itemFileDTOs[1].file_name}" alt="..."> --%>
				<div id="lineParent">
					<h3 id="line">준비됐다</h3>
				</div>
				
				<img src="getImage?file_name=${myItemFile.itemFileDTOs[myDTO.pet_evolution].file_name}" alt="" id="petImg" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="left" data-bs-content="무기를 드래그해서 공격하세요" data-my->
				<c:if test="${not empty myWeaponFile}">
				<img src="getImage?file_name=${myWeaponFile.itemFileDTOs[0].file_name}" alt="" id="weaponImg">				
				</c:if>
				
				
			</div>

			<div id="enemyParent">
				<%-- <img src="getImage?file_name=${itemDTO.itemFileDTOs[1].file_name}" alt="..."> --%>
				<div id="lineEnemyParent" class="mb-2">
					<h3 id="enemyLine">나도 준비됐다</h3>
				</div>
				<c:if test="${not empty enemyItemFile}">
				<img src="getImage?file_name=${enemyItemFile.itemFileDTOs[enemyDTO.pet_evolution].file_name}"  class="droppable" alt="" id="enemyImg" data-bs-toggle="modal" data-bs-target="#fightResultModal">
				</c:if>
				
				<c:if test="${not empty enemyWeaponFile}">
				<img src="getImage?file_name=${enemyWeaponFile.itemFileDTOs[0].file_name}" alt="" id="enemyWeaponImg">
				</c:if>

				<!-- 경기 종료 모달 -->
				<div id="fightResult">
					<div class="modal fade" id="fightResultModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-labelledby="modalActLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-scrollable">
							<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="modalActLabel">${users_info.user_id} VS ${enemyDTO.user_id}</h1>
								<button id="actCloseBtn" type="button" class="btn-close" data-bs-toggle="modal" data-bs-dismiss="modal" aria-label="Close">X</button>
							</div>
							<div class="modal-body">
							<div class="form-floating" id="modalImg">
								<img id="fightResultImg" class="petAct" src="" alt="character image" data-mypet-num="${myDTO.pet_num}" data-enemypet-num="${enemyDTO.pet_num}">
								
							</div>
							</div>
							<div class="modal-footer">
								<div class="input-group mb-3 justify-content-center">
									
									<!-- <a href="./ingame" id="done" class="btn btn-outline-secondary close" type="button" data-bs-toggle="modal" data-bs-dismiss="modal" aria-label="Close">확인</a> -->
									<a id="check" class="btn btn-outline-warning" type="button">결과보기</a>
									<a href="./ingame" id="goHome" class="btn btn-outline-warning" type="button">홈으로 가기</a>
								</div>
								
							</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
		
			
			
			

			  


	
	
			


		
		  
       

	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<script src="/resources/js/ingame/fight.js"></script>
	
	<c:import url="../template/boot-footer.jsp"></c:import>

</body>
</html>