package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Guest;
import com.revature.repositories.GuestRepository;

@Service
public class GuestService {
	
	GuestRepository guestRepository;
	
	@Autowired
	public GuestService (GuestRepository guestRepository){
		super();
		this.guestRepository = guestRepository;
	}


	public Guest createGuest(Guest guest) {
		// TODO Auto-generated method stub
		return guestRepository.createGuest(guest);
	}

}
