package com.springmvc.exception;

@SuppressWarnings("serial")
public class bookIdException extends RuntimeException {

	private String bookid;
	
	public bookIdException(String bookid) {
		this.bookid=bookid;
	}

	public String getBookid() {
		return bookid;
	}
}
