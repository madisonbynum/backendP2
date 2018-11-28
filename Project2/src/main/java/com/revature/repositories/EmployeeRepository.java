//package com.revature.repositories;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.revature.beans.Reservation;
//
//@Repository
//public class EmployeeRepository {
//
//	SessionFactory sf;
//
//	// Look at Austin and Caleb's code
//	@Transactional
//	public void checkIn(Reservation rs) {
//		sf.getCurrentSession().update(rs);
//	}
//
//	// Look at Austin and Caleb's code
//	@Transactional
//	public void checkOut(Reservation rs) {
//		sf.getCurrentSession().update(rs);
//	}
//
//	@Autowired
//	public EmployeeRepository(SessionFactory sf) {
//		super();
//		this.sf = sf;
//	}
//
//}
