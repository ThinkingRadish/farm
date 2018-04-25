package com.news.web;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginService {

	@Autowired
	UserEntityRepository repository;
	@Autowired
	BoardController bc;
	@Autowired
	HttpServletResponse response;

	public String loginLogic(String name, String pass){
		UserEntity entity = repository.findByName(name);

		if((!(Objects.isNull(entity)) && entity.getPass().equals(pass))){

			Cookie cookie = new Cookie("userName", entity.getName());
			cookie.setMaxAge(60 * 30);
			cookie.setPath("/");
			cookie.setSecure(false);
			response.addCookie(cookie);

			return "LoginSucceeded";
		}else{
			return "LoginFailed";
		}

	}
}
