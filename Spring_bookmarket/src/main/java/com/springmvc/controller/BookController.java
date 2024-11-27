package com.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.service.BookService;
import com.springmvc.validator.BookValidator;
import com.springmvc.validator.UnitsInStockValidator;
import com.springmvc.dto.Book;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import com.springmvc.exception.*;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	//autowired 하려면 스캔되야함
	
	@Autowired
	private BookValidator bookValidator;
	
	@Autowired
	private UnitsInStockValidator unitsInStockValidator;
	
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
		
		if(booksByCategory==null || booksByCategory.isEmpty()) {
			throw new CategoryException();
		}
		
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
	
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute Book book) {
		return "addBook";
	}
	
	@PostMapping("/add")
	public String postMethodName(@Valid @ModelAttribute Book book,BindingResult result,HttpServletRequest req) {
		
		if(result.hasErrors()) {

			return "addBook";
		}
		
		MultipartFile bookImage=book.getBookImage();
		String save=req.getServletContext().getRealPath("/resources/images");
		System.out.println(save);
		String saveName=bookImage.getOriginalFilename();
		File saveFile= new File(save,saveName);
		
		if(bookImage !=null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(saveFile);
				book.setFileName(saveName);
			} catch (Exception e) {
				throw new RuntimeException("도서 이미지 업로드가 실패하였습니다.",e);
			}
		}
		bookService.setNewBook(book);
		return "redirect:/books";
	}
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 도서 등록");
		model.addAttribute("home", "Home");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(unitsInStockValidator);
		binder.setValidator(bookValidator);
		binder.setAllowedFields("bookId","name","unitPrice","author","description","publisher","category","unitsInStock","totalPages","releaseDate","condition","bookImage");
	}
	
	@ExceptionHandler(value = {bookIdException.class})
	public ModelAndView handleError(HttpServletRequest req,bookIdException exception) {
		ModelAndView mav =new ModelAndView();
		mav.addObject("invalidBookId",exception.getBookid());
		mav.addObject("exception",exception);
		mav.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("errorBook");
		return mav;
	}
	

}
