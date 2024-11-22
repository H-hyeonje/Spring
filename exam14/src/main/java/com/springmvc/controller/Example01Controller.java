package com.springmvc.controller;

import java.util.HashMap;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
@RequestMapping("/exam01")
public class Example01Controller {

		@GetMapping
		public String showForm() {
			return "webpage14_01";
		}
		
		@PostMapping
		public String submit(@RequestBody String param,Model model) {
			model.addAttribute("title","@RequestBody로 정보 받기");
			model.addAttribute("result",param);
			return "webpage14_result";
		}
		
		
		@GetMapping("/json")
		public String showForm1() {
			//TODO: process PUT request
			
			return "webpage14_02";
		}
		
		@PostMapping("/test")
		public void submit2(@RequestBody HashMap<String, Object> map) {
			System.out.println(map);
		}
		
		
		
	
}
