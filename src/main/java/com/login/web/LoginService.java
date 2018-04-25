package com.login.web;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.web.BoardController;
import com.cookie.web.CookieLogic;
import com.news.web.UserEntity;
import com.news.web.UserEntityRepository;



@Service
public class LoginService {

	@Autowired
	UserEntityRepository repository;
	@Autowired
	BoardController bc;
	@Autowired
	CookieLogic cl;

	public String loginLogic(String name, String pass){
		UserEntity entity = repository.findByName(name);
		if((!(Objects.isNull(entity)) && entity.getPass().equals(pass))){
			return cl.bakeCookie(entity);
		}else{
			return "LoginFailed";
		}
	}
}
