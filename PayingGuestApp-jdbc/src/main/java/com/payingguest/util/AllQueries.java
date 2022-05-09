package com.payingguest.util;

public class AllQueries {
	
	// for pg
	
	public static final String INSERTQUERY ="insert into payingguest (paying_guest_id,name,address ,pgType ,rating) values (?,?,?,?,?)";
	
	public static final String DELETEQUERY ="delete from payingguest where paying_guest_id=?";
	
	public static final String FINDPGBYID ="select * from payingguest pg inner join rooms r on pg.paying_guest_id=r.paying_guest_id  where pg.paying_guest_id=?";
	
	public static final String FINDBYLOCATION ="select * from  payingguest pg inner join rooms r on pg.paying_guest_id=r.paying_guest_id  where pg.address=?";
	
	public static final String FINDBYPGTYPE ="select * from  payingguest where pgType=?";
	
	
	

	
	// for  rooms 
	
	public static final String INSERTRQUERY ="insert into rooms (roomType,cost,roomId  ,no_of_rooms,paying_guest_id) values (?,?,?,?,?)";
	
	public static final String DELETEROOMQUERY ="delete from rooms where roomId=?";
	
	public static final String FINDBYSHARE ="select * from rooms r inner join  payingguest pg on r.paying_guest_id=pg.paying_guest_id where roomType=?";
		
}
