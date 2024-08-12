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
            <!-- row -->
    </div>
    <div>
    <table>
    	<thead>
    		<tr>
    			<th scope="col">글 번호</th>
    			<th scope="col">작성자</th>
    			<th scope="col">제목</th>
    			<th scope="col">작성일</th>
    			<th scope="col">조회수</th>
    			<th scope="col">내용</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    		<c:forEach items="${list}" var="list">
    			<tr>
	    			<th scopt="row">${list.board_num}></th>
	    			<td><a href class="btn">${list.board_title}</a></td>
	    			<td><a href class="btn">${list.user_id}</a></td>
	    			<td><a href class="btn">${list.board_hit}</a></td>
	    			<td><a href class="btn">${list.board_create_date}</a></td>

    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    </div>
    
    
	<c:import url="./template/footer.jsp"></c:import>
	<c:import url="./template/boot-footer.jsp"></c:import>
	</div>
</body>
</html>