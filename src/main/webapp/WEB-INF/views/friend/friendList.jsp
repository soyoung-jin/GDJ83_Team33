<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<c:import url="../template/header.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/friend.css">
</head>
<body id="reportsPage" class="font">
	
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<h1 class="text-white mt-5 mb-5">내 친구들</h1>

					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
					<div class="row gx-5 justify-content-center">
						<!-- Pricing card free-->
						<c:choose>
							<c:when test="${not empty usersDTO.friendDTO[0].friend_num}">
								<c:forEach items="${list}" var="list" varStatus="status">
									<div class="col-lg-6 col-xl-4 mb-5">
										<a class="text-white"
											href="./friendDetail?friend_num=${usersDTO.friendDTO[status.index].friend_num}">
											<div class="card cardBorder ">
												<div class="card-body p-5">
													<div class="small bold text-white">${status.count}</div>
													<div class="tm-avatar-container">
													<img id="friendImg" src="getImage?file_name=${list.itemFileDTOs[list.pet_evolution].file_name}" class="tm-avatar img-fluid mb-4" alt="...">
														
													</div>
													<div class="mb-3">
														<h2 class="display-5 fw-bold text-white">${list.user_id}</h2>
													</div>

												</div>
											</div>
										</a>
									</div>
									<br>
								</c:forEach>

							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<c:import url="../template/boot-footer.jsp"></c:import>
	</div>
	</div>
	<script>
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
	<script src="/resources/js/friend/chat.js"></script>
</body>
</html>
