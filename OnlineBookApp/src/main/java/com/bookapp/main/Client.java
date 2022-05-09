package com.bookapp.main;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.bookapp");
		IBookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);

		Scanner s = new Scanner(System.in);
		for (;;) {
			System.out.println("Enter A for Admin");
			System.out.println("Enter C for Customer");
			System.out.println("Enter E for exit");

			String input = s.next();
			char key = input.toUpperCase().charAt(0);

			if (key == 'A') {
				System.out.println("Enter 1 for adding book");
				System.out.println("Enter 2 to Delete Book");
				System.out.println("Enter 3 to Get Book data by Book ID");
				System.out.println("Enter 4 to Update Book");

				int choice = s.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Book ID");
					int Id = s.nextInt();

					System.out.println("Enter Book Title");
					String title = s.next();

					System.out.println("Enter Book Author ");
					String author = s.next();

					System.out.println("Enter Book Category ");
					String category = s.next();

					System.out.println("Enter Book Price ");
					int price = s.nextInt();

					bookService.addBook(new Book(Id, author, category, title, price));
					System.out.println("book sucessfully added");
					break;
				case 2:
					System.out.println("Enter Book ID -");
					int bookId = s.nextInt();
					bookService.deleteBook(bookId);
					System.out.println("book sucessfully deleted");
					break;
				case 3:
					System.out.println("Enter Book ID -");
					bookId = s.nextInt();
					try {
						System.out.println(bookService.getById(bookId));
					} catch (IdNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter the book Id");
					bookId = s.nextInt();
					System.out.println("Enter the new price");
					price = s.nextInt();
					bookService.updateBook(bookId, price);
					System.out.println("Book was updated Succesfully");
					break;

				default:
					System.out.println("Invalid input");
					break;
				}

			} else if (key == 'C') {
				System.out.println("Eenter 1 to Get all book");
				System.out.println("Enter 2 to get all books by author");
				System.out.println("Eenter 3 to Get all books by category");
				System.out.println("Enter 4 to get all books by lesser price");

				int choice = s.nextInt();
				switch (choice) {
				case 1:
					List<Book> bookList = bookService.getAll();
					for (Book book : bookList) {
						System.out.println(book);
					}

					break;
				case 2:
					System.out.println("Enter Author name :");
					String author = s.next();
					try {
						bookList = bookService.getByAuthor(author);
						for (Book book : bookList) {
							System.out.println(book);
						}
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Enter category name :");

					String category = s.next();
					try {
						bookList = bookService.getByAuthor(category);
						for (Book book : bookService.getByCategory(category)) {
							System.out.println(book);
						}
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter a price ");
					double price = s.nextInt();
					try {
						bookList = bookService.getByLesserPrice(price);
						for (Book book : bookList) {
							System.out.println(book);
						}
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				default:
					System.out.println("Invalid Statement");
					break;
				}
			} else if (key == 'E') {
				System.out.println("Application has ended");
				System.exit(0);
			} else {
				System.out.println("Invalid Entry");
			}
		}
	}

}
