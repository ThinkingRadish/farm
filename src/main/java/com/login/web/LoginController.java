package com.login.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cookie.web.CookieLogic;
import com.registration.web.RegistrationService;

@Controller
public class LoginController {
	@Autowired
	RegistrationService rs;
	@Autowired
	LoginService ls;
	@Autowired
	CookieLogic cl;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String toLoginView(){
		return "LoginView";
	}

	@RequestMapping(value ="/toRegisterNewUser", method=RequestMethod.GET)
	public String toCreateNewUser(){
		return "RegisterNewUser";
	}

	@RequestMapping(value="/toRegistrationResult", method=RequestMethod.POST)
	public String toRegistrationResult(@RequestParam("newName")String newName,
	@RequestParam("newPass")String newPass){
		return rs.registrationLogic(newName, newPass);
	}

	@RequestMapping(value="/toLoginResult", method=RequestMethod.POST)
	public String toLoginResult(@RequestParam("name")String name,
	@RequestParam("pass")String pass, Model model){
		cl.deleteCookie();
		model.addAttribute("name", name);
		return ls.loginLogic(name, pass);
	}

	@RequestMapping("/logout")
	public String logout(){
		cl.deleteCookie();
		return "/Logout";
	}
}
