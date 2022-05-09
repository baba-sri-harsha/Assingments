package com.payingguest.service;

import java.util.List;
import java.util.stream.Collectors;

import com.payingguest.dao.IRoomDao;
import com.payingguest.dao.RoomDaoImpl;
import com.payingguest.exception.RoomTypeNotFoundException;

import com.payingguest.model.Rooms;



public class RoomServiceImpl implements IRoomService {
	
	

	private IRoomDao roomDao= new RoomDaoImpl();

	@Override
	public void addRoom(Rooms room) {
		roomDao.addRoom(room);
		
		
	}
	
	
	@Override
	public List<Rooms> getByShare(String roomType) throws RoomTypeNotFoundException {
		List<Rooms> getByShareList= roomDao.getByShare(roomType);
		if(getByShareList.isEmpty())
			throw new RoomTypeNotFoundException("Paying guest not found");
		return getByShareList.stream()
				.sorted((o1,o2)->o1.getRoomType().compareTo(o2.getRoomType()))
				.collect(Collectors.toList());
	
	}


	@Override
	public void deleteRoom(int roomId) {
		roomDao.deleteRoom(roomId);
		
	}

	
	
	

}
