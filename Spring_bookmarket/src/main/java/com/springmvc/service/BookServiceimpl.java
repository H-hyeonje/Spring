package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.dto.Book;
import com.springmvc.dao.BookRepository;
@Service
public class BookServiceimpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Override
	public List<Book> getAllBookList() {
		System.out.println("서비스 왓냐");
		// TODO Auto-generated method stub
		return bookRepository.getAllBookList();
	}
	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory =bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}
	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}
	@Override
	public Book getBookById(String bookId) {
		Book bookById=bookRepository.getBookById(bookId);
		return bookById;
	}
	
	
}
