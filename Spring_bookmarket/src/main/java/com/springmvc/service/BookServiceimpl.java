package com.springmvc.service;

import java.util.List;

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
}
