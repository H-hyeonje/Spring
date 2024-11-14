package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class WelcomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("greeting","Welcom to BookMarket");
		model.addAttribute("strapline","Welcom to Web shopping Mall!");
		return "welcom";
	
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcomea(Model model) {
		model.addAttribute("greeting","Welcom to BookMarket");
		model.addAttribute("strapline","Welcom to Web shopping Mall!");
		return "welcom";
	
	}
	
	
}