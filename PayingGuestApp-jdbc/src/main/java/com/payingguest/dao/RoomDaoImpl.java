package com.payingguest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.payingguest.model.Rooms;
import com.payingguest.util.AllQueries;

public class RoomDaoImpl implements IRoomDao {
	
	static Connection connection = null;

	@Override
	public void addRoom(Rooms room) {
		PreparedStatement preparedStatement = null;
		 connection = ConnectionUtil.openConnection();
		
		try {
			preparedStatement= connection.prepareStatement(AllQueries.INSERTRQUERY);
			preparedStatement.setString(1,room.getRoomType());
			preparedStatement.setDouble(2, room.getCost());
			preparedStatement.setInt(3,room.getRoomId());
			preparedStatement.setInt(4,room.getnoOfRooms());
			preparedStatement.setDouble(5, room.getPayingGuestId());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					if(preparedStatement!=null);
					preparedStatement.close();
					System.out.println("Room has been added sucessfully");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
		}ConnectionUtil.closeConnection();
	
	}

	

	@Override
	public void deleteRoom(int roomid) {
		PreparedStatement preparedStatement= null;
		connection= ConnectionUtil.openConnection();
		
		try {
			preparedStatement= connection.prepareStatement(AllQueries.DELETEROOMQUERY);
			preparedStatement.setInt(1,roomid );
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
					System.out.println("Room has been deleted sucessfully");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}ConnectionUtil.closeConnection();
		}
		
	}



	



	@Override
	public List<Rooms> getByShare(String roomtype) {
		
		PreparedStatement preparedStatement = null;
		connection =ConnectionUtil.openConnection();
		Rooms rooms=null;
		
		List<Rooms> roomsList = new ArrayList<Rooms>();
		
			try {
				preparedStatement = connection.prepareStatement(AllQueries.FINDBYSHARE);
				preparedStatement.setString(1, roomtype);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String room= rs.getString("roomtype");
					double cost = rs.getDouble("cost");
					int roomid = rs.getInt("roomid");
					int noofrooms=rs.getInt("no_of_rooms");
					int payingGuestId= rs.getInt("paying_guest_id");
					rooms = new Rooms(room, cost, roomid, noofrooms, payingGuestId);
					roomsList.add(rooms);			
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement!=null) {
						preparedStatement.close();
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}ConnectionUtil.closeConnection();
		return roomsList;		
	}
	
	

	

}
