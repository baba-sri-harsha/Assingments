package com.bookapp.util;

public class AllQueries {
	public static final String SELECTQUERY= "select * from book ";
	
	public static final String AUTHORQUERY="select * from book where author=?";
	
	public static final String CATQUERY= "select * from book where category=?";
	
	public static final String PRICEQUERY= "select * from book where price<=?";
	
	public static final String INSERTQUERY= "insert into book (bookId,title, author, category, price) values (?,?,?,?,?)";
	
	public static final String UPDATEQUERY= "update  book set price =? where bookId=?";
	
	public static final String SELECTIONQUERY="select * from book where bookId=?";
	
	public static final String DELETIONQUERY ="delete from book where bookId=?";
	
	
}
