<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="/resources/css/ingame.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

	<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
	<c:import url="../template/topbar.jsp"></c:import>
	
			<!-- 캐릭터 상태&기본행위 메뉴 -->
			
			<div class="row justify-content-end mt-3 mr-3 petMenu">
				<div class="col-sm-4 col-lg-3 col-md-3 justify-content-center ">
				  <div class="card">
						<div class="card-body">
							<h5 class="card-title">펫이름</h5>
							<p class="card-text"><a href="#" id="petStatusBtn" data-bs-toggle="modal" data-bs-target="#petStatusModal">펫 상태 보기</a></p>
								<div class="justify-content-center align-item-center">

								<!-- 펫 상태 보기 모달 버튼 -->
								
								<a href="./feed" id="feed" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#actModal">먹이주기</a>
								<a href="./stroll" id="stroll" class="btn btn-primary mt-2 mb-2" data-bs-toggle="modal" data-bs-target="#actModal">산책하기</a>
								<a href="./clean" id="clean" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#actModal">청소하기</a>
								</div>
						</div>
					</div>
				</div>
			</div>
		
			<!-- 펫 행동 모달(식사,산책,화장실) -->
			
			<div id="petDiv">
				<div class="modal fade" id="actModal" tabindex="-1" aria-labelledby="modalActLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-scrollable">
						<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="modalActLabel"></h1>
							<button id="actCloseBtn" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
						</div>
						<div class="modal-body">
						<div class="form-floating" id="modalImg">
							<img id="actImg" class="petAct" src="" alt="">
							
						</div>
						</div>
						<div class="modal-footer">
							<div class="input-group mb-3 justify-content-center">
								
								<button id="doneFeeding" class="btn btn-outline-secondary close" type="button" data-bs-dismiss="modal" aria-label="Close">확인</button>
								
							</div>
							
						</div>
						</div>
					</div>
				</div>
			</div>

			  <!-- 펫 상태 보기 모달 -->
			  
			  <div id="petStatusDiv">
				<div class="modal fade" id="petStatusModal" tabindex="-1" aria-labelledby="petStatusModal" aria-hidden="true">
					<div class="modal-dialog modal-dialog-scrollable">
					  <div class="modal-content">

						<div class="modal-header">
						  <h1 class="modal-title fs-5" id="petStatusModal">마이펫</h1>
						  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
						</div>

						<div class="modal-body">
						 <!-- 펫 상태 리스트 -->
						 <div class="tm-block-col tm-col-account-settings" id="petStatusList">
							<div class="tm-bg-primary-dark tm-block tm-block-settings">
								<h2 class="tm-block-title">캐릭터 정보</h2>
								<form action="" class="tm-signup-form row">
									<div class="form-group col-lg-6">
										<label for="pet_spc">종족</label>
										<input id="pet_spc" name="pet_spc" value="${myPetDTO.pet_spc}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_level">레벨</label>
										<input id="pet_level" name="pet_level" value="${myPetDTO.pet_level}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_exp">경험치</label>
										<input id="pet_exp" name="pet_exp" value="${myPetDTO.pet_exp}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_hp">체력</label>
										<input id="pet_hp" name="pet_hp" value="${myPetDTO.pet_hp}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_atk">공격력</label>
										<input id="pet_atk" name="pet_atk" value="${myPetDTO.pet_atk}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_dod">회피력</label>
										<input id="pet_dod" name="pet_dod" value="${myPetDTO.pet_dod}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_pop">인기도</label>
										<input id="pet_pop" name="pet_pop" value="${myPetDTO.pet_pop}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
									<div class="form-group col-lg-6">
										<label for="pet_hungry">포만감</label>
										<input id="pet_hungry" name="pet_hungry" value="${myPetDTO.pet_hungry}"
											type="text" class="form-control validate" readonly style="background-color:#4e657a"/>
									</div>
								</form>
							</div>
						  </div>
						</div>
					  </div>
					</div>
				  </div>
			   </div>


	
	
			<!-- 펫이랑 대화 모달 -->
			
			<div class="container">
				<div id="petParent">
					<img id="myPet" src="/resources/img/ingame/ex2.gif" alt="moving cracked egg">
					<div id="chatDiv">
	
						<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-dialog-scrollable">
							  <div class="modal-content">

								<div class="modal-header">
								  <h1 class="modal-title fs-5" id="exampleModalLabel">마이펫</h1>
								  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
								</div>

								<!-- 대화 내용 -->
								<div class="modal-body">
								 <div class="form-floating" id="modalContent">
									
									
								  </div>
								</div>
								<div class="modal-footer">
								  <div class="input-group mb-3">
									  <input type="text" class="form-control" id="chatContent" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
									  <button class="btn btn-outline-secondary" type="button" id="sendBtn">보내기</button>
									  
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
	<script src="/resources/js/ingame/ingame.js"></script>
	<script src="/resources/js/ingame/petAct.js"></script>
	<c:import url="../template/boot-footer.jsp"></c:import>

</body>
</html>