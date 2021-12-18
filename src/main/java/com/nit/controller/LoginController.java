package com.nit.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.model.Users;
import com.nit.service.UserLoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	
	@Autowired
	public UserLoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		Users loginForm = new Users();
		model.put("login", loginForm);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Users loginForm, BindingResult result,Model model) {

		
		if (result.hasErrors()) {
			return "login";
		}
		
		
		boolean userExists = loginService.checkLogin(loginForm.getUserName(),
                loginForm.getUserPassword());
		if(userExists){
			model.addAttribute("login", loginForm);
			return "home";
		}else{
			model.addAttribute("error","invalid user");
			return "login";
		}

	}

	
}
