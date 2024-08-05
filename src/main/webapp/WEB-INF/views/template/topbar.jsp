<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <i class="fas fa-tachometer-alt"></i>
                                게임시작
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span>
                                    게시판 <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">공지사항</a>
                                <a class="dropdown-item" href="#">유저 게시판</a>
                                <a class="dropdown-item" href="#">랭킹 게시판</a>
                                <a class="dropdown-item" href="#">문의 게시판</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="products.html">
                                <i class="fas fa-shopping-cart"></i>
                                상점
                            </a>
                        </li>

                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user"></i>
                                <span>
                                    마이페이지 <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Profile</a>
                                <a class="dropdown-item" href="#">Billing</a>
                                <a class="dropdown-item" href="#">Customize</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
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
                    </ul>
                </div>
            </div>

        </nav>