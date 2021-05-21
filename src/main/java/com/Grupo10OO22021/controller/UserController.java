package com.Grupo10OO22021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Grupo10OO22021.helpers.ViewRouteHelper;

@Controller
public class UserController {

	@GetMapping("/login")
	public String login() {
		return ViewRouteHelper.USER_LOGIN;
	}
	
	@GetMapping("/logout")
	public String logout() {
		return ViewRouteHelper.USER_LOGOUT;
	}
	
}
