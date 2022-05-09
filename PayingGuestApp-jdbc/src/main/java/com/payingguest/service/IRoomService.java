package com.payingguest.service;

import java.util.List;

import com.payingguest.exception.RoomTypeNotFoundException;
import com.payingguest.model.Rooms;

public interface IRoomService {

	void addRoom(Rooms room);

	void deleteRoom(int roomId);

	List<Rooms> getByShare(String roomType) throws RoomTypeNotFoundException;

}
