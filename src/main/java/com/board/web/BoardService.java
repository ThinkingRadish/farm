package com.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookie.web.CookieLogic;
import com.news.web.TextEntity;
import com.news.web.TextEntityRepository;

@Service
public class BoardService {
	@Autowired
	TextEntityRepository ter;
	@Autowired
	TextEntityRepository tRepository;
	@Autowired
	CookieLogic cl;

	public List<TextEntity> getBoardText(){
		List<TextEntity> textLists = ter.findAll();
		return textLists;
	}

	public String postLogic(String text){
		if(text.equals("")){
			return "NoText";
		}
		return cl.getCookieValue(text);
	}
}
