package com.news.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieLogic {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	public void deleteCookie(){
		try{
			Cookie cookies[] =request.getCookies();
			for (Cookie cookie : cookies ) {
				if ("userName".equals(cookie.getName())) {
			        cookie.setMaxAge(0);
			        cookie.setPath("/");
			        response.addCookie(cookie);
			    }
			}
		}catch(NullPointerException e){
			System.out.println(e);
		}
	}


}
