package com.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cookie.web.CookieLogic;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;
	@Autowired
	CookieLogic cl;

	@RequestMapping("/MainBoard")
	public String toMainBoard(Model model){
		model.addAttribute("textData", bs.getBoardText());
		return cl.checkCookie();
	}

	@RequestMapping(value="/PostTextResult", method=RequestMethod.POST)
	public String toPostTextResult(@RequestParam("text")String text){
		return bs.postLogic(text);
	}
}
