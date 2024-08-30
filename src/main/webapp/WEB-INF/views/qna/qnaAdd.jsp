<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>QUESTION</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>

    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">문의사항 새 글쓰기</h2>
              </div>
            </div>
            <div class="row tm-edit-product-row">
              <div class="col-xl-12 col-lg-6 col-md-12">
              <form  class="tm-edit-product-form" method="post">
                <input type="hidden" value="${users_info.user_id}" name="user_id">
                  <div class="form-group mb-3">
                    <label
                      for="name"
                      >제목
                    </label>
                    <input id="question_title" name="question_title" type="text" class="form-control validate" required/>
                  </div>
                  <div class="form-group mb-3">
                    <label for="contents">내용</label>
                    <textarea 
                      class="form-control validate" name="question_contents" id="question_contents"rows="10"required></textarea>
                  </div>
			</div>
                </div>
              </div>
              <div class="col-12">
                <button class="btn btn-primary btn-block text-uppercase">등록</button>
              </div>
            </form>
            </div>
          </div>
        </div>
      </div>
    </div>
   
	
	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
</body>
</html>