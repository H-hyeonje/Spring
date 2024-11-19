package com.springmvc.controller;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/exam01")
public class ex01controller {
	
		@GetMapping("/form")
		public String requestForm() {
			System.out.println("여왓냐");
			return "webpage09_01";
		}
		
		
		@PostMapping("/form")
		public String submitForm(HttpServletRequest req,@RequestParam("name") String name, @RequestParam("fileImage") MultipartFile file) {
			String imges=req.getServletContext().getRealPath("/resources/images");
			String filename=file.getOriginalFilename();
			File f=new File(imges+"_"+filename);
			System.out.println(imges);
			try {
				file.transferTo(f);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return "webpage09_submit";
		}
		
	}	
	
