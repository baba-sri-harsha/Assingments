package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {


	private IBookDao bookDao;
	@Autowired
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.addBook(book);
		
	}

	public void updateBook(int bookId, double price) {
		// TODO Auto-generated method stub
		bookDao.updateBook(bookId, price);
		
	}

	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(bookId);
		
	}

	public Book getById(int bookId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Book book = bookDao.getById(bookId);
		if (book==null)
			throw new IdNotFoundException("Invalid Id");
		
		return book;
	}

	public List<Book> getAll() {
		List<Book> books = bookDao.findAll();
		return books.stream().sorted(Comparator.comparing(Book::getBookId)).collect(Collectors.toList());
				
				
		}
	
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = bookDao.findByAuthor(author);
		if(booksByAuthor.isEmpty())
			throw new BookNotFoundException("Books by this author"+author+"not found");
		return booksByAuthor.stream()
				.sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle()))
				.collect(Collectors.toList());
	}

	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> booksByCategory = bookDao.findByCategory(category);
		if(booksByCategory.isEmpty())
			throw new BookNotFoundException("Books by this author"+category+"not found");
		return booksByCategory.stream()
				.sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle()))
				.collect(Collectors.toList());
	}

	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> booksByLessPrice = bookDao.findByLesserPrice(price);
        if (booksByLessPrice.isEmpty()) {
                throw new BookNotFoundException("Books by the price range below " + price + " not found");
        }
        return booksByLessPrice.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()))
                        .collect(Collectors.toList());
	}

}
