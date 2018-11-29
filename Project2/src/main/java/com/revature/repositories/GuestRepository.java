package com.revature.repositories;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Guest;
import com.revature.beans.HostedAt;
import com.revature.beans.OccupiedRoom;
import com.revature.beans.Reservation;
import com.revature.beans.ReservedRoom;
import com.revature.beans.Room;
import com.revature.enums.ReservedRoomStatus;
import com.revature.enums.RoomType;

@Repository
public class GuestRepository {
	
//	static SessionFactory sf;
	static Logger log = Logger.getRootLogger();
	
	@Autowired
	static SessionFactory sf;
	
//	@Autowired
//	public GuestRepository(SessionFactory sf) {
//		super();
//		this.sf = sf;
//	}
	
	ReservedRoomStatus status = ReservedRoomStatus.AVAILABLE;
	RoomType single = RoomType.SINGLE;
	RoomType Double = RoomType.DOUBLE;
	RoomType master = RoomType.MASTER_SUITE;

	public static SessionFactory setUpSessionFactory() {
		/*
		 * Adds the stuff from somewhere and configures it.
		 */
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Guest.class)
				.addAnnotatedClass(Reservation.class)
				.addAnnotatedClass(HostedAt.class)
				.addAnnotatedClass(OccupiedRoom.class)
				.addAnnotatedClass(ReservedRoom.class)
				.addAnnotatedClass(Room.class)
				.buildSessionFactory();
		return factory;
	}
	
	public Guest createGuest(Guest guest) {
		sf = setUpSessionFactory();
		try(Session session = sf.openSession()) {
			session.save(guest);
			return guest;
		}
	}
}
