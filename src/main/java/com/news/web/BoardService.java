package com.news.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	TextEntityRepository ter;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	TextEntityRepository tRepository;

	public List<TextEntity> getBoardText(){
		List<TextEntity> textLists = ter.findAll();
		return textLists;
	}

	public String postLogic(String text){
		if(text.equals("")){
			return "NoText";
		}
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



}
