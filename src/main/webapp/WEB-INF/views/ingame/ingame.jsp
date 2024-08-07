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
			<div class="row justify-content-end">
				<div class="col-sm-5 justify-content-center ">
				  <div class="card">
					<div class="card-body">
					  <h5 class="card-title">펫이름</h5>
					  <p class="card-text">펫상태1</p>
					  <p class="card-text">펫상태2</p>
					  <p class="card-text">펫상태3</p>
					  <div>
					  <a href="#" class="btn btn-primary">밥주기</a>
					  <a href="#" class="btn btn-primary">산책하기</a>
					  <a href="#" class="btn btn-primary">똥치우기</a>
					  </div>
					</div>
				  </div>
				</div>
			  </div>
	
		<div class="container">


			<div id="petParent">
				<img id="myPet" src="/resources/img/ingame/ex2.gif" alt="moving cracked egg">
				<div id="chatDiv">

					<div class="modal fade" id="commentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-scrollable">
						  <div class="modal-content">
							<div class="modal-header">
							  <h1 class="modal-title fs-5" id="exampleModalLabel">To. ${usersDTO.friendDTO[0].friend_id}</h1>
							  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
							</div>
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
	<c:import url="../template/boot-footer.jsp"></c:import>

</body>
</html>