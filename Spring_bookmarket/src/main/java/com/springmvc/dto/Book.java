package com.springmvc.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.validator.BookId;

public class Book implements Serializable {
	
	private static final long serialVersionUID = -7715651009026349175L;
	public Book() {}
	
	public Book(String bookId,String name, int unitPrice) {
		this.bookId=bookId;
		this.name=name;
		this.unitPrice=unitPrice;
	}
	
	@BookId
	@Pattern(regexp="ISBN[1-9]+", message="{Pattern.book.bookId}")
	private String bookId; 
	
	@Size(min=4,max=50,message="{Size.book.name}")
	private String name; 
	
	@Min(value=0,message="{Min.book.unitPrice}")
	@Digits(integer=8, fraction=2,message="{Digits.book.unitPrice}")
	@NotNull(message="{NotNull.book.unitPrice}")
	private int unitPrice; 
	
	
	private String author; 
	private String description; 
	private String publisher; 
	private String category; 
	private long unitsInStock; 
	private String releaseDate; 
	private String condition; 
	private MultipartFile bookImage;
	
	
	
	
	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
