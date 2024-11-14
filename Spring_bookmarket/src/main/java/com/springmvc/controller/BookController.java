package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.service.BookService;
import com.springmvc.dto.Book;
@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public String requestBookList(Model model) {
		System.out.println("왓냐");
		List<Book> list =bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
	
}
