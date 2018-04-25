package com.news.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BoardController {
	@Autowired
	BoardService bs;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	@RequestMapping("/MainBoard")
	public String toMainBoard(Model model){
		model.addAttribute("textData", bs.getBoardText());
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

	@RequestMapping(value="/PostTextResult", method=RequestMethod.POST)
	public String toPostTextResult(@RequestParam("text")String text){
		return bs.postLogic(text);
	}


}
