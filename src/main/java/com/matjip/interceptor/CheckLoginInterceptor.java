package com.matjip.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.matjip.bean.UserBean;



public class CheckLoginInterceptor implements HandlerInterceptor {
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// 로그인 안 한 상태라면

		
		// 로그인 한 상태라면		
		return true;
		// 그다음 컨트롤러 진행됨
	}
	
	
	
	

}
