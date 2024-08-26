package com.team3.tamagochi.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team3.tamagochi.users.UsersDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Controller 진입 전 통과하는 interceptor
		UsersDTO usersDTO = (UsersDTO)request.getSession().getAttribute("users_info");
		
		if(usersDTO.getUser_auth() != 0) {
			request.setAttribute("result", "관리자만 접근 가능합니다.");
			request.setAttribute("url", "/");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);
			
			return false;
		}
		return true;
	}
}
