<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="/">
                    <img alt="jumping tamagochi" src="/resources/img/tama.gif"><h1 class="tm-site-title mb-0">Home</h1>
                </a>
                <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars tm-nav-icon"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <c:choose>
	                    	<c:when test="${not empty users_info}">
                        <li class="nav-item">
                            <a class="nav-link active" href="/ingame/ingame">
                                <i class="fas fa-tachometer-alt"></i>
                                게임시작
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        </c:when>
                        </c:choose>
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span>
                                    게시판 <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/notice/noticeList">공지사항</a>
                                <a class="dropdown-item" href="/userboard/userboardList">유저 게시판</a>
                                <a class="dropdown-item" href="/rank/rankList">랭킹 게시판</a>
                                <a class="dropdown-item" href="/qna/qnaList">문의 게시판</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/store/itemList">
                                <i class="fas fa-shopping-cart"></i>
                                상점
                            </a>
                        </li>

                <c:choose>
	                <c:when test="${not empty users_info}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user"></i>
                                <span>
                                    마이페이지 <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/users/mypage">내 정보</a>
                                <a class="dropdown-item" href="/mypet/mypetList">내 캐릭터</a>
                                <a class="dropdown-item" href="/users/inventory">인벤토리</a>
                                <a class="dropdown-item" href="/store/getWishList">장바구니</a>
                                <a class="dropdown-item" href="/friend/friendList">내 친구들</a>
                            </div>
                        </li>
                    </c:when>
                </c:choose>
                        <!-- 관리자 권한이 있는 유저만 해당 탭을 볼 수 있음 -->
                        <c:if test="${users_info.user_auth eq 0 }">
	                        <li class="nav-item dropdown">
	                            <a class="nav-link" href="/admin/adminMain">
	                                <i class="far fa-user"></i>
	                                    관리자 페이지
	                            </a>
	                        </li>                        
                        </c:if>
                    </ul>
                    <!-- session에 로그인 정보가 있으면 로그아웃을 출력, 로그인 정보가 없으면 로그인을 출력 -->
		            <ul class="navbar-nav">
	                    <c:choose>
	                    	<c:when test="${not empty users_info}">
			                        <li class="nav-item">
			                            <a class="nav-link d-block" href="/users/logout">
			                                 <b>로그아웃</b>
			                            </a>
			                        </li>
			                        <li class="nav-item">
			                            <a class="nav-link d-block" href="/users/mypage">
			                                 <b>${users_info.user_nickname }님</b>
			                            </a>
			                        </li>
                                    
                                    <div class="dropdown table-hover" >
                                        <li class="nav-item">
                                            <a class="nav-link d-block dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                                                <img style="width: 25px;" alt="bell" src="/resources/img/index/bell.png">
                                            </a>
                                            
                                            <ul class="dropdown-menu" id="notification">
                                                <li id="recentAlarm">최근 5개 알림</li>
                                                <hr>
                                                <c:forEach items="${alarmList}" var="list">
                                                <li><a class="dropdown-item">${list.alarm_contents}</a></li>
                                                </c:forEach>
                                                <li><a href="/friend/alarmList?user_id=${users_info.user_id}" class="dropdown-item">전체 알람 보기</a></li>
                                            </ul>
                                        </li>
                                      </div>
	                    	</c:when>
	                    	<c:otherwise>
			                        <li class="nav-item">
			                            <a class="nav-link d-block" href="/users/login">
			                                 <b>로그인</b>
			                            </a>
			                        </li>
			                        <li class="nav-item">
			                            <a class="nav-link d-block" href="/users/register">
			                                 <b>회원가입</b>
			                            </a>
			                        </li>
	                    	</c:otherwise>
	                    </c:choose>
		            </ul>
                </div>
            </div>
        </nav>
        