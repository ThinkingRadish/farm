package com.cookie.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.web.TextEntity;
import com.news.web.TextEntityRepository;
import com.news.web.UserEntity;

@Service
public class CookieLogic {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	TextEntityRepository tRepository;

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

	public String checkCookie(){
		try{
			Cookie cookies[] =request.getCookies();
			for (Cookie cookie : cookies ) {
				if ("userName".equals(cookie.getName())) {
					return "/MainBoard";
				}
			}
		}catch(NullPointerException e){
			System.out.println(e);
		}
		return "/FMainBoard";
	}

	public String getCookieValue(String text){
		try{
			Cookie cookies[] =request.getCookies();
			for (Cookie cookie : cookies ) {
				if ("userName".equals(cookie.getName())) {
					TextEntity tEntity = new TextEntity(cookie.getValue(), text);
					tRepository.save(tEntity);
					return "PostSucceeded";
				}
			}
		}catch(NullPointerException e){
			System.out.println(e);
		}
		return "NoName";
	}

	public String bakeCookie(UserEntity entity){
		Cookie cookie = new Cookie("userName", entity.getName());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/");
		cookie.setSecure(false);
		response.addCookie(cookie);
		return "LoginSucceeded";
	}
}
