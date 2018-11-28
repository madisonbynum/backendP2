package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.beans.Guest;
import com.revature.repositories.GuestRepository;

@Service
public class GuestService {
	
	GuestRepository guestRepository;

	public Guest save(Guest guest) {
		// TODO Auto-generated method stub
		return guestRepository.save(guest);
	}

}
