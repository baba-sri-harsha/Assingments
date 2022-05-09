package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	
	List<Book> getByAuthor(String Author) throws BookNotFoundException;
	
	List<Book>getByLesserPrice(double price);
	Book getById(int bookId) throws BookNotFoundException;
	

	String addBook(Book book);
}
