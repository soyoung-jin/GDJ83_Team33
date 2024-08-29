<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
	<c:import url="./template/header.jsp"></c:import>
	
</head>
<body id="reportsPage" class="font">
	<div class="" id="home">
	<c:import url="./template/topbar.jsp"></c:import>
	
	<main>

		<div class="container text-center mb-5" id="headerTop">
			<div class="row">
				<div class="col">
					<h1 id="title" class="text-white mt-5 mb-5 textLines"><b>웹으로 키우는 다마고치 어떠세요?</b></h1>
					<img id="tamagotchi" src="/resources/img/index/tamagotchi.png" alt="">
				</div>
			</div>
	
			
				<!-- row -->
		</div>
<hr>
		<section class="py-5 text-center container mt-5">
		  <div class="row py-lg-5">
			<div class="col-lg-6 col-md-8 mx-auto">
			  <h2 class="fw-light text-white mb-5 textLines">다양한 캐릭터를 만나보세요!</h2>
			</div>
			  <img id="bunch" src="/resources/img/index/bunch.PNG" alt="">
		  </div>
		</section>
	  <hr>
		<div class="album py-5 bg-body-tertiary text-center">
		  <div class="container">
			  
			  <h2 class="fw-light text-white mb-5 textLines">다마고치를 진화시킬 수 있어요!</h2>
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			  <div class="col">
				<div class="card shadow-sm">
				  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
					<image href="/resources/img/index/sample1.gif" height="100%" width="100%"/>
				</svg>
				  <div class="card-body">
					<p class="card-text">0단계</p>
					<p class="card-text">레벨 0 ~ 레벨 9</p>
					
				  </div>
				</div>
			  </div>
			  
			  <div class="col">
				<div class="card shadow-sm">
				  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
					<image href="/resources/img/index/sample2.gif" height="100%" width="100%"/>
				 </svg>
				  <div class="card-body">
					<p class="card-text">1단계</p>
					<p class="card-text">레벨 10 ~ 레벨 19</p>
					
				  </div>
				</div>
			  </div>
			  <div class="col">
				<div class="card shadow-sm">
					<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
						<image href="/resources/img/index/sample3.gif" height="100%" width="100%"/>
					</svg>
					<div class="card-body">
						<p class="card-text">2단계</p>
						<p class="card-text">레벨 20 ~ 레벨 29</p>
					
				    </div>
				</div>
			  </div>
	  
			  <div class="col">
				<div class="card shadow-sm">
					<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
						<image href="/resources/img/index/sample4.gif" height="100%" width="100%"/>
					 </svg>
				  <div class="card-body">
					<p class="card-text">3단계</p>
					<p class="card-text">레벨 30 ~ 레벨 100</p>
					
				  </div>
				</div>
			  </div>
			  
			  </div>
			</div>
		  </div>

		  <section class="py-5 text-center container">
			
				
				<h1 class="fw-light mb-5 text-white textLines">지금 바로 가입해서 플레이하십시오</h1>
				
				  <a id="goSign" href="/users/register" class="btn btn-primary my-2">가입하러 가기</a>
				  <a id="goStore" href="/store/itemList" class="btn btn-primary text-white my-2">상점 구경하기</a>
				</p>
			  
		  </section>
		
	  
	  </main>

	
	<c:import url="./template/footer.jsp"></c:import>
	<c:import url="./template/boot-footer.jsp"></c:import>
	
	</div>
</body>
</html>