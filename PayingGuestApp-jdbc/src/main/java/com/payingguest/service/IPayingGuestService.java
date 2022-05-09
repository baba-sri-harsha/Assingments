package com.payingguest.service;

import java.util.List;

import com.payingguest.exception.IdNotFoundException;
import com.payingguest.exception.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;

public interface IPayingGuestService {
	
	void addPayingGuest(PayingGuest payingGuest);
	
	void deletePayingGuest(int payingGuestId);
	
	PayingGuest getById(int payingGuestId) throws  IdNotFoundException;
	
//customer
	
	List<PayingGuest>getByLocation(String location) throws PayingGuestNotFoundException ;
		
	List<PayingGuest>getBytype(String payingGuestType) throws PayingGuestNotFoundException;
	
	
}
