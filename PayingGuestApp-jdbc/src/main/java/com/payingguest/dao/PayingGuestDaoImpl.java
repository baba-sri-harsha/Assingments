package com.payingguest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.payingguest.model.PayingGuest;
import com.payingguest.util.AllQueries;

public class PayingGuestDaoImpl implements IPayingGuestDao {
	
	
	static Connection connection;
	

	public void addPayingGuest(PayingGuest payingGuest) {
		
		PreparedStatement preparedStatement = null;
		connection= ConnectionUtil.openConnection();
		
		try {
			preparedStatement= connection.prepareStatement(AllQueries.INSERTQUERY);
			preparedStatement.setInt(1,payingGuest.getPayingGuestId());
			preparedStatement.setString(2,payingGuest.getName());
			preparedStatement.setString(3,payingGuest.getAddress());
			preparedStatement.setString(4,payingGuest.getPgType());
			preparedStatement.setString(5,payingGuest.getRating());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(preparedStatement!=null);
					preparedStatement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
		}ConnectionUtil.closeConnection();
	
	}

	public void deletePayingGuest(int payingGuestId) {
		
		PreparedStatement preparedStatement= null;
		connection= ConnectionUtil.openConnection();
		
		try {
			preparedStatement= connection.prepareStatement(AllQueries.DELETEQUERY);
			preparedStatement.setInt(1, payingGuestId);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}ConnectionUtil.closeConnection();
		}
	}
	
	
	public PayingGuest findById(int payingGuestId) {
		
		PreparedStatement preparedStatemnet = null;
		connection =ConnectionUtil.openConnection();
		PayingGuest payingGuest= null;
		
		try {
			preparedStatemnet = connection.prepareStatement(AllQueries.FINDPGBYID);
			preparedStatemnet.setInt(1, payingGuestId);
			ResultSet rs =preparedStatemnet.executeQuery();
			

			while(rs.next()) {
				int payingGuestId1= rs.getInt("paying_guest_id");
				String name= rs.getString("name");
				String address= rs.getString("address");
				String pgType= rs.getString("pgType");
				String rating = rs.getString("rating");
						
				payingGuest = new PayingGuest(payingGuestId1,name, address,pgType, rating);

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatemnet!=null) {
					preparedStatemnet.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		
		return payingGuest;
	}

	public List<PayingGuest> findtByLocation(String location) {
		PreparedStatement preparedStatement = null;
		connection =ConnectionUtil.openConnection();
		PayingGuest payingGuest=null;
		
		List<PayingGuest> payingGuestList = new ArrayList<PayingGuest>();
		
			try {
				preparedStatement = connection.prepareStatement(AllQueries.FINDBYLOCATION);
				preparedStatement.setString(1, location);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int payingGuestId1= rs.getInt("paying_guest_id");
					String name= rs.getString("name");
					String address= rs.getString("address");
					String pgType= rs.getString("pgType");
					String rating = rs.getString("rating");
							
					payingGuest = new PayingGuest(payingGuestId1,name, address,pgType, rating);
					payingGuestList.add(payingGuest);
				}
			} catch (SQLException e) {
			
				e.getMessage();
			}finally {
				try {
					if(preparedStatement!=null) {
						preparedStatement.close();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}ConnectionUtil.closeConnection();
			}
		return payingGuestList;		
	}

	public List<PayingGuest> findBytype(String payingGuestType) {
		
		PreparedStatement preparedStatement = null;
		connection =ConnectionUtil.openConnection();
		PayingGuest payingGuest=null;
		
		List<PayingGuest> payingGuestList = new ArrayList<PayingGuest>();
		
			try {
				preparedStatement = connection.prepareStatement(AllQueries.FINDBYPGTYPE);
				preparedStatement.setString(1, payingGuestType);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int payingGuestId1= rs.getInt("paying_guest_id");
					String name= rs.getString("name");
					String address= rs.getString("address");
					String pgType= rs.getString("pgType");
					String rating = rs.getString("rating");
							
					payingGuest = new PayingGuest(payingGuestId1,name, address,pgType, rating);
					payingGuestList.add(payingGuest);
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
				}ConnectionUtil.closeConnection();
			}
		return payingGuestList;		

		
	}



}
