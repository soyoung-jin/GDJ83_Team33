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
				
				<img src="/resources/img/ingame/ex2.gif" alt="" id="petImg" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="left" data-bs-content="무기를 드래그해서 공격하세요">
				
				<img src="/resources/img/ingame/weapon3.png" alt="" id="weaponImg">
				
				
			</div>

			<div id="enemyParent">
				<%-- <img src="getImage?file_name=${itemDTO.itemFileDTOs[1].file_name}" alt="..."> --%>
				<div id="lineEnemyParent">
					<h3 id="enemyLine">나도 준비됐다</h3>
				</div>
				<img src="/resources/img/character/Character4_4.gif"  class="droppable" alt="" id="enemyImg">
				<img src="/resources/img/ingame/weapon5.png" alt="" id="enemyWeaponImg">
				
				
			</div>
		</div>
	</div>
		
			
			
			

			  


	
	
			


		
		  
       

	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<script src="/resources/js/ingame/fight.js"></script>
	
	<c:import url="../template/boot-footer.jsp"></c:import>

</body>
</html>