package com.bookapp.testcases;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {

	@Mock
	IBookService bookService; // creating a proxy of BookService
	OrderDetails orderDetails;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1, book2, book3, book4, book5;

	@BeforeEach
	void setUp() throws Exception {
		// create an object of orderdetails to test the methods
		
				
		orderDetails = new OrderDetails();

		// inject the bookservice into orderdetails

		orderDetails.setBookService(bookService);

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
	@DisplayName("Testing By Author")
	void testFindByAuthor() throws BookNotFoundException {

		String author = "Kathy";
		
		List<Book> booksByAuthor = Arrays.asList(book1, book2, book5);

		// mock the method and assume it returns a list of books by author

		when(bookService.getByAuthor(author)).thenReturn(booksByAuthor);

		// after getting the data, test the method of orderdetails

		List<Book> books = orderDetails.findByAuthor(author);

		assertNotNull(books);
	}

	@Test
	@DisplayName("Testing By Author - returning null")
	void testFindByAuthorNull() throws BookNotFoundException {

		String author = "kathy";
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book> books = orderDetails.findByAuthor(author);
		assertNull(books);

	}

	@Test
	@DisplayName("Testing By Author - sort by name")
	void testFindByAuthorName() throws BookNotFoundException {

		String author = "kathy";

		List<Book> expected = Arrays.asList(book2, book1, book5);
		when(bookService.getByAuthor(author)).thenReturn(expected);

		// if null/empty throw exception
		List<Book> actual = orderDetails.findByAuthor(author);
		assertEquals(expected.toString(), actual.toString());

	}

	@Test
	@DisplayName("Testing By Author - empty list")
	void testFindByAuthoEmpty() throws BookNotFoundException {

		String author = "kathy";

		when(bookService.getByAuthor(author)).thenReturn(new ArrayList<Book>());

		assertThrows(BookNotFoundException.class, () -> orderDetails.findByAuthor(author));

	}

	@Test
	@DisplayName("Testing By Author - empty list")
	void testByAuthorException() throws BookNotFoundException {
		String author = "paul";
		when(bookService.getByAuthor(author)).thenThrow(new BookNotFoundException(author));
		assertThrows(BookNotFoundException.class, () -> orderDetails.findByAuthor(author));
	}
	
	
	@Test
	@DisplayName("testing verify")
	void  testVerify() throws BookNotFoundException {
		String author = "kathy";
		List<Book> expected= Arrays.asList(book2,book1, book5);
		
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book2,book5));
		List<Book> actualList = orderDetails.findByAuthor(author);
		assertEquals(expected.toString(),actualList.toString());
		assertNotNull(actualList);
		
		when((bookService).getByAuthor(author)).thenReturn(null);
		List<Book> actualList1 = orderDetails.findByAuthor(author);
		assertNull(actualList1);
		
		Mockito.verify(bookService,times(2)).getByAuthor(author);
		Mockito.verify(bookService,atLeastOnce()).getByAuthor(author);
		Mockito.verify(bookService,atLeast(2)).getByAuthor(author);
	}
	
	

}