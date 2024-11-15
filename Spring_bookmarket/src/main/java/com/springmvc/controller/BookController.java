package com.springmvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.BookService;
import com.springmvc.dto.Book;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	//autowired 하려면 스캔되야함
	
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("왓냐");
		List<Book> list =bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		ModelAndView modvi=new ModelAndView();
		System.out.println("all왓냐");
		List<Book> list =bookService.getAllBookList();
		modvi.addObject("bookList",list);
		modvi.setViewName("books");
		return modvi;
	}
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory,Model model)
	{
		System.out.println(bookCategory);
		List<Book> booksByCategory=bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList",booksByCategory);
		return "books";
	}
	
	@GetMapping("/fiter/{bookFilter}")
	public String requestBooksByFilter(
			@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter,
			Model model
			) {
		Set<Book> booksByFilter=bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList",booksByFilter);
		return "books";
	}
	
	@GetMapping("/book")
	public String RequestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById=bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
	

}
