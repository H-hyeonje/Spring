package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dto.Book;
import com.springmvc.dto.Cart;
import com.springmvc.dto.CartItem;
import com.springmvc.exception.bookIdException;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping(value="/cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String requestCartId(HttpServletRequest req) {
		String sessionid =req.getSession(true).getId();
		
		return "redirect:/cart/"+sessionid;
	}
	
	
	@PostMapping
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		
		return cartService.create(cart);
	}
	
	@GetMapping("/{cartId}")
	public String requestCartList(@PathVariable(value = "cartId") String cartId,Model model) {
		Cart cart=cartService.read(cartId);
		model.addAttribute("cart",cart);
		
		return "cart";
	}
	
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable (value ="cartId") String cartId) {
		//TODO: process PUT request
		
		return cartService.read(cartId);
	}
	
	
	@PutMapping("/add/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest req) {
		String sessionId=req.getSession(true).getId();
		Cart cart=cartService.read(sessionId);
		if(cart==null) 
			cart=cartService.create(new Cart(sessionId));
			Book book = bookService.getBookById(bookId);
			if(book==null){
				throw new IllegalArgumentException(new bookIdException(bookId));
				
			}
			cart.addCartItem(new CartItem(book));
			cartService.update(sessionId, cart);
	}
}
