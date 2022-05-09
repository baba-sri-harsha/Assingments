package com.bookapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {

	// depends on IBookService

	IBookService bookService;

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookService.getByAuthor(author);

		if (books != null) {
			if (books.isEmpty())
				throw new BookNotFoundException();
			return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
		} else
			return null;

	}

	public String orderBook(int bookId) {
		try {
			Book book = bookService.getById(bookId);
			if (book != null)
				return "ordered Sucessfully";
			else
				return "Book not ordered";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "technical issue - try again";
	}
	
	public String addBook (Book book) {
		if(book == null) 
			return "book not added";
		else {
			bookService.addBook(book);
			return "Book Added";
			
		}
		
	}


}
