package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HOMEController {
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	      Date date = new Date();
	      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	      
	      String formattedDate = dateFormat.format(date);
	      
	      model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	@RequestMapping(value="/test")
	public String test(Model model) {
		String test= "안녕하세요!";
		model.addAttribute("tt", test);
		return "test";
	}
}
