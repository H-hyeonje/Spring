package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class loginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/loginfailed")
	public String loginfailed(Model model) {
		model.addAttribute("error","true");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "login";
	}
	
	
	
}
