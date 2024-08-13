<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<table class="table table-hover tm-table-small tm-product-table">
		<thead>
		  <tr>
			<th scope="col"><input type="checkbox" /></th>
			<th scope="col"></th>
			<th scope="col">이름</th>
			<th scope="col">설명</th>
			<th scope="col">체력</th>
			<th scope="col">공격력</th>
			<th scope="col">회피력</th>
			<th scope="col">가격</th>
			<th scope="col"><a href="#" class="tm-product-delete-link">
				<i class="far fa-trash-alt tm-product-delete-icon"></i>
			  </a></th>
		  </tr>
		</thead>
		<tbody>
			  <c:forEach items="${wishlist}" var="list">
				  <tr>
					  <td scope="row"><input type="checkbox"/></td>
					  <td><div class="tm-gray-circle"><img src="/resources/img/character/4.gif" width="80" alt="Avatar Image" class="rounded-circle"></div></td>
					  <td class="tm-product-name">${list.itemDTO.item_name}</td>
					  <td>${list.itemDTO.item_description}</td>
					  <td>${list.itemDTO.item_hp}</td>
					  <td>${list.itemDTO.item_atk}</td>
					  <td>${list.itemDTO.item_dod}</td>
					  <td>${list.itemDTO.item_price}</td>
					  <td class="delbtn">
						  <a class="tm-product-delete-link">
						  <i class="far fa-trash-alt tm-product-delete-icon" id="${list.wishlist_num}"></i>
						  </a>
					  </td>
				  </tr>
			  </c:forEach>
		  </tbody>
	  </table>