package com.springmvc.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.dto.*;
public interface BookRepository {
	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	Book getBookById(String bookId);
	void setNewBook(Book book);
}
