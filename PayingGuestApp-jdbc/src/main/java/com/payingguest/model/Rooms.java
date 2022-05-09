package com.payingguest.model;

public class Rooms {
	
	

	String roomType;
	double cost;
	Integer roomId;
	int noOfRooms;
	Integer payingGuestId;
	
	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Rooms(String roomType, double cost, Integer roomId, int noOfRooms, Integer payingGuestId) {
		super();
		this.roomType = roomType;
		this.cost = cost;
		this.roomId = roomId;
		this.noOfRooms = noOfRooms;
		this.payingGuestId = payingGuestId;
	}
	

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public int getnoOfRooms() {
		return noOfRooms;
	}

	public void setnoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public Integer getPayingGuestId() {
		return payingGuestId;
	}

	public void setPayingGuestId(Integer payingGuestId) {
		this.payingGuestId = payingGuestId;
	}
	
	@Override
	public String toString() {
		return "Rooms [roomType=" + roomType + ", cost=" + cost + ", roomId=" + roomId + ", noOfRooms=" + noOfRooms
				+ ", payingGuestId=" + payingGuestId + "]";
	}

}
