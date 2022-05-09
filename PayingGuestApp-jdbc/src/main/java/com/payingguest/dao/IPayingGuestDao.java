package com.payingguest.dao;

import java.util.List;

import com.payingguest.model.PayingGuest;

public interface IPayingGuestDao {
	
	//admin
	
		void addPayingGuest(PayingGuest payingGuest);
		
		void deletePayingGuest(int payingGuestId);
		
		PayingGuest findById(int payingGuestId);
		
	//customer
		
		List<PayingGuest>findtByLocation(String location);
			
		List<PayingGuest>findBytype(String payingGuestType);
		
		
}
