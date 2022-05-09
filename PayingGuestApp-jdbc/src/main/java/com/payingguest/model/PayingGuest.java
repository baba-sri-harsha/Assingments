package com.payingguest.model;



public class PayingGuest {

	private Integer payingGuestId;
	private String name;
	private String address;
	private String pgType;
	private String rating;
	
	public PayingGuest() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public PayingGuest(Integer payingGuestId, String name,String address, String pgType, String rating) {
		super();
		this.payingGuestId = payingGuestId;
		this.name = name;
		this.address = address;
		this.pgType = pgType;
		this.rating = rating;
	}

	

	public Integer getPayingGuestId() {
		return payingGuestId;
	}

	public void setPayingGuestId(Integer payingGuestId) {
		this.payingGuestId = payingGuestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPgType() {
		return pgType;
	}

	public void setPgType(String pgType) {
		this.pgType = pgType;
	}
	 
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "PayingGuest [payingGuestId=" + payingGuestId + ", name=" + name + ", address=" + address + ", pgType="
				+ pgType + ", rating=" + rating + "]";
	}


}
