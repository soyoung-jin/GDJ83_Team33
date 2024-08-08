<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<c:import url="../template/header.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/friend.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<p class="text-white mt-5 mb-5">
						Welcome, <b>Admin</b>
					</p>
				</div>
			</div>
		<div class="container px-5 my-5">
			<div class="row gx-5 justify-content-center">
			
		<button type="button" id="startChat" class="btn btn-outline-warning chatBtn" data-bs-toggle="modal" data-bs-target="#commentModal">
		  채팅 시작
		</button>
		
		<!-- 댓글 모달 창 -->
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
		
				
				<div class="col-lg-8 col-xl-8">
					<div class="card mb-5 mb-xl-0 ">
							<div class="card-body p-5">
									<div>
										<img style="width:20%"alt="mockImage" src="/resources/img/friendImage/chick.png">
									</div>
								
									<div class="mb-2">
										<span class="display-5 fw-bold">${usersDTO.user_nickname}</span>
									</div>
									<ul class="list-unstyled mb-4">
										<li class="mb-2">
										<strong>${usersDTO.user_phone}</strong>
										</li>
										<li class="mb-2">
										<strong>${usersDTO.user_email}</strong>
										</li>
									</ul>
							</div>
						</div>
						<div class="d-md-flex justify-content-md-end mt-5">
							<a class="btn btn-secondary justify-content-end" href="./friendList" role="button">돌아가기</a>
							<a class="btn btn-danger justify-content-end ml-2" href="deleteFriend?friend_num=${usersDTO.friendDTO[0].friend_num}" role="button">친구 끊기</a>
						</div>
				</div>
				
					<!-- 선물 보내기 버튼 -->
					<button type="button" id="gift" class="btn btn-outline-warning ml-3 chatBtn">
					  선물보내기
					</button>
	        	</div>
	    	</div>  
		</div>
	</div>

		<footer class="tm-footer row tm-mt-small fixed-bottom">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. 
                    
                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer>
        
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script src="/resources/js/chat/chat.js"></script>
<c:import url="../template/boot-footer.jsp"></c:import>
</body>
</html>
