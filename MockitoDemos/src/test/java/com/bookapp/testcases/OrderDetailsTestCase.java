package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTestCase {
	
	@Mock
	IBookService bookService;
	
	@InjectMocks
	OrderDetails details;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1, book2, book3, book4, book5;
	@BeforeEach
	void setUp() throws Exception {

		book1 = new Book(1, "Java", "Kathy", 900);
		book2 = new Book(2, "JSP", "Kathy", 200);
		book3 = new Book(3, "Seven Habits", "Steve", 300);
		book4 = new Book(4, "5am Club", "Robin", 800);
		book5 = new Book(5, "Spring", "Kathy", 100);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("testing correct order")
	void testOrderBook() throws BookNotFoundException {
		int bookId=1;
		doReturn(book1).when(bookService).getById(1);
		String actual=details.orderBook(bookId);
		assertEquals("ordered Sucessfully", actual);
	}
	
	@Test
	@DisplayName("testing book returned is null")
	void testOrdered() throws BookNotFoundException {
		doReturn(null).when(bookService).getById(1);
		String actual= details.orderBook(1);
		assertEquals("Book not ordered", actual);
	}
	
	@Test
	@DisplayName("testing book returning exception")
	void testOrderBookException() throws BookNotFoundException {
		int bookId=1;
		doThrow(new BookNotFoundException("Book not found")).when(bookService).getById(bookId);
		String actual= details.orderBook(1);
		assertEquals("technical issue - try again", actual);
	}
	//mocking a method that return nothing -void return type
	
	@Test
    @DisplayName("Testing Add Book with noReturn type")
    void testAddBook() {
    	doNothing().when(bookService).addBook(book1);
    	String actual = details.addBook(book1);
    	assertEquals("Book Added", actual);
    }

	
	@Test
	@DisplayName("Testing add null book with void type")
	void testAddBookNull(Book book) {
		
		String actual =details.addBook(null);
		assertEquals("Book  not added",actual );
	}
}
