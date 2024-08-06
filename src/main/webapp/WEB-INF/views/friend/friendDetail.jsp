<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<p class="text-white mt-5 mb-5">
						Welcome, <b>Admin</b>
					</p>
				</div>
			</div>
			<div class="container px-5 my-5">
		<div class="row gx-5 justify-content-center">
			<div class="col-lg-8 col-xl-8">
                  <div class="card mb-5 mb-xl-0 ">
                        <div class="card-body p-5">
                              	<div>
                              		<img style="width:200px"alt="mockImage" src="/resources/img/friendImage/chick.png">
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
         				 <a class="btn btn-danger justify-content-end ml-2" href="deleteFriend?friend_num=${usersDTO.friendDTO.friend_num}" role="button">친구 끊기</a>
        			 </div>
             </div>
        </div>
    </div>  
		</div>
		<c:import url="../template/footer.jsp"></c:import>
		<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
</body>
</html>
