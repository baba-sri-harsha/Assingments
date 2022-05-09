package com.payingguest.dao;

import java.util.List;

import com.payingguest.model.Rooms;

public interface IRoomDao {
	
	//boolean addRoom(String )
	
	void addRoom(Rooms room);
	
	void deleteRoom(int roomId);
	
	List<Rooms>getByShare(String roomType);
	
	
}
