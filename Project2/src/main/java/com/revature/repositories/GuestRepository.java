package com.revature.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestRepository {
	SessionFactory sf;
	
	/**
	 * Meant as a way to extract the guest information
	 * @param sf
	 */
	
	@Autowired
	public GuestRepository(SessionFactory sf) {
		super();
		this.sf = sf;
	}

}
