<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>NOTICE</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>


<div class="container mt-5">
      <div class="row tm-content-row">
        <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-products">
            <div class="tm-product-table-container">
              <table class="table table-hover tm-table-small tm-product-table">
                <thead>
                  <tr>
                    <th scope="col">&nbsp;</th>
                    <th scope="col">글 번호</th>
                    <th scope="col">작성자</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성일</th>
                    <th scope="col">조회수</th>
                    <th scope="col">&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
				
					<c:forEach var="list" items="${list}">
                  <tr>
                    <th scope="row"><input type="checkbox" /></th>
                    <td class="tm-product-name">${list.notice_num}</td>
                    <td>${list.user_id}</td>
                    <td>>${list.notice_title}</td>
                    <td>${list.notice_create_date}</td>
                    <td>${list.notice_hit}</td>
                    <td>
                      <a href="#" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- table container -->
            <a
              href="./noticeAdd"
              class="btn btn-primary btn-block text-uppercase mb-3">공지사항 글쓰기</a>
            <button class="btn btn-primary btn-block text-uppercase">
              공지사항 지우기
            </button>
          </div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
            <h2 class="tm-block-title">게시판 카테고리</h2>
            <div class="tm-product-table-container">
              <table class="table table-hover tm-table-small tm-product-table">
                <tbody>
                  <tr>
                    <td class="tm-product-name">공지사항</td>
                    <td class="text-center"></td>
                    
                  </tr>
                  <tr>
                    <td class="tm-product-name">유저 게시판</td>
                    <td class="text-center">

                    </td>
                  </tr>
                  <tr>
                    <td class="tm-product-name">랭킹 게시판</td>
                    <td class="text-center">

                    </td>
                  </tr>
                  <tr>
                    <td class="tm-product-name">문의 게시판</td>
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
    <script>
    $(function() {
      $(".tm-product-name").on("click", function() {
        window.location.href = "edit-product.html";
      });
    });	
  </script>

	
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
</body>
</html>