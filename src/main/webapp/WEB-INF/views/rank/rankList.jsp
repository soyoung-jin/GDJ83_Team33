<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>RANKING</title>
<c:import url="../template/header.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/rank.css">
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container mt-5">
			<div class="row tm-content-row">
				<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9 tm-block-col">
					<h1 class="text-white mt-12 mb-12">랭킹 게시판</h1>

					<div class="tm-bg-primary-dark tm-block tm-block-h-auto" style="display:inline-block;">
						<div class="col-sm-4 col-md-4 col-lg-12 col-xl-12 tm-block-col">
							<div class="row justify-content-center" id="go">

							<c:forEach items="${list}" var="list" varStatus="status">
								<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
								<div class="col-sm-8 col-md-8 col-lg-6 col-xl-6 tm-block-col">
									<!-- 카드형 태그 -->
									<div class="card h-10">
										<c:choose>
											<c:when test="${users_info.user_id == list.user_id}">
											<h1>내 순위: ${status.count}위</h1>	
											</c:when>
											<c:otherwise>
											<h1>${status.count}위</h1>	
											</c:otherwise>
										</c:choose>
										<!-- 디테일가기위한 a태그 -->
										<a href="/rank/rankDetail?pet_num=${list.pet_num }">
											<!-- 카드형 상부 이미지 -->
											<img src="/resources/img/character/4.gif" class="card-img-top" alt="...">
										</a>
										<div class="card-body">
											<!-- 카드 이미지 하단 아이템명, 가격 -->
											<c:choose>
												
												<c:when test="${list.pet_selected == 1 }">
												
												
											<h5 class="card-title">닉네임: ${list.usersDTO.user_nickname}</h5>
											<h5 class="card-title">펫 이름: ${list.pet_name }</h5>
											<h5 class="card-title">레벨: ${list.pet_level }</h5>
											<h5 class="card-title">인기도: <p style="display:inline-block;"> ${list.pet_pop}</p></h5>
												</c:when>
											</c:choose>
													<div>
													<a style="display: inline;" id="rankplay" href="../ingame/fight?item_num=${list.item_num}&user_id=${list.user_id}"><img style="width:40%; " src="/resources/img/rankboard/playimg.png"></a> 
																					
													<a style="display: inline;" id="ranklike" href="javascript:void(0);" class="pop_btn" data-pet-num="${list.pet_num}"><img class="pop_btn" style="width:20%; float:center;" src="/resources/img/rankboard/likeimg.png"></a> 
													</div>
												
										</div>
									</div>
								</div>							
							</c:forEach>
							</div>
						</div>
					</div>
					<!-- row -->
				</div>
		<div class="col-sm-5 col-md-5 col-lg-3 col-xl-3 tm-block-col" style="display: inline-block;">
          <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
            <h2 class="tm-block-title">게시판 카테고리</h2>
            <div class="tm-product-table-container">
              <table class="table table-hover tm-table-small tm-product-table">
                <tbody>
                  <tr>
                    <td class="tm-notice-notice">공지사항</td>
                    <td class="text-center">
                      <a href="#" class="">
                      </a>
                    </td>
                  </tr>
                  <tr>
                    <td class="tm-notice-user">유저 게시판</td>
                    <td class="text-center">

                    </td>
                  </tr>
                  <tr>
                    <td class="tm-notice-lank">랭킹 게시판</td>
                    <td class="text-center">

                    </td>
                  </tr>
                  <tr>
                    <td class="tm-notice-qna">문의 게시판</td>
                    <td class="text-center">

                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
       </div>
	</div>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
    
    $(function() {
        $(".tm-notice-notice").on("click", function() {
          window.location.href = "../notice/noticeList";
        });
      });</script>
      
      
        <script type="text/javascript">
    
    $(function() {
        $(".tm-notice-user").on("click", function() {
          window.location.href = "../userboard/userboardList";
        });
      });</script>
      
         <script type="text/javascript">
    
    $(function() {
        $(".tm-notice-lank").on("click", function() {
          window.location.href = "../rank/rankList";
        });
      });</script>
      
      
         <script type="text/javascript">
    
    $(function() {
        $(".tm-notice-qna").on("click", function() {
          window.location.href = "../qna/qnaList";
        });
      });</script>

   
		

	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	<script src="/resources/js/users/myPetList.js"></script>
	<script src="/resources/js/rank/rankboard.js"></script>
</body>
</html>
	

</body>
</html>