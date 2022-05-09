package com.payingguest.service;

import java.util.List;
import java.util.stream.Collectors;

import com.payingguest.dao.IPayingGuestDao;
import com.payingguest.dao.PayingGuestDaoImpl;
import com.payingguest.exception.IdNotFoundException;
import com.payingguest.exception.PayingGuestNotFoundException;
import com.payingguest.model.PayingGuest;

public class PayingGuestServiceImpl implements IPayingGuestService {
	
	private IPayingGuestDao payingGuestDao= new  PayingGuestDaoImpl();

	@Override
	public void addPayingGuest(PayingGuest payingGuest) {
	
		payingGuestDao.addPayingGuest(payingGuest);
		
	}

	@Override
	public void deletePayingGuest(int payingGuestId) {
	
		payingGuestDao.deletePayingGuest(payingGuestId);
		
	}

	

	@Override
	public PayingGuest getById(int payingGuestId) throws IdNotFoundException {
		PayingGuest payingGuest= payingGuestDao.findById(payingGuestId);
		
		if(payingGuest==null) {
			throw new IdNotFoundException("Invalid Id");
		}
		return payingGuest;
	}

	@Override
	public List<PayingGuest> getByLocation(String location) throws PayingGuestNotFoundException  {
		List<PayingGuest> payingGuestLocation= payingGuestDao.findtByLocation(location);
		if(payingGuestLocation.isEmpty())
			throw new PayingGuestNotFoundException("Paying guest not found");
		return payingGuestLocation.stream()
				.sorted((o1,o2)->o1.getAddress().compareTo(o2.getAddress()))
				.collect(Collectors.toList());
	}

	@Override
	public List<PayingGuest> getBytype(String payingGuestType) throws PayingGuestNotFoundException {
		List<PayingGuest> payingGuestTypeList= payingGuestDao.findBytype(payingGuestType);
		if(payingGuestTypeList.isEmpty())
			throw new PayingGuestNotFoundException("Paying guest not found");
		return payingGuestTypeList.stream()
				.sorted((o1,o2)->o1.getAddress().compareTo(o2.getAddress()))
				.collect(Collectors.toList());
	}
	

}
