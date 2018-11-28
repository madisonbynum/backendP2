package com.revature;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.beans.Guest;
import com.revature.beans.HostedAt;
import com.revature.beans.OccupiedRoom;
import com.revature.beans.Reservation;
import com.revature.beans.ReservedRoom;
import com.revature.beans.Room;
import com.revature.enums.ReservedRoomStatus;
import com.revature.enums.RoomType;

public class Launcher {
	static SessionFactory sf;
	static Logger log = Logger.getRootLogger();
	
	ReservedRoomStatus status = ReservedRoomStatus.AVAILABLE;
	RoomType single = RoomType.SINGLE;
	RoomType Double = RoomType.DOUBLE;
	RoomType master = RoomType.MASTER_SUITE;
	public static void main(String[] args) {
		sf= setUpSessionFactory();
		Launcher launcher = new Launcher();
		launcher.createRoom(); 
		

		
		
	}
	
	public static SessionFactory setUpSessionFactory() {
		/*
		 * Adds the stuff from somewhere and configures it.
		 */
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(OccupiedRoom.class)
				.addAnnotatedClass(Reservation.class)
				.addAnnotatedClass(ReservedRoom.class)
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Guest.class)
				.addAnnotatedClass(OccupiedRoom.class)
				.addAnnotatedClass(HostedAt.class)
				.buildSessionFactory();
		
		return factory;
	}
	
	public Room createRoom() {
		try(Session session = sf.openSession()){
			Room room1 = new Room(single, new ArrayList<OccupiedRoom>(), 100, status, true, true );
			Room room2 = new Room(single, new ArrayList<OccupiedRoom>(), 101, status, true, true );
			Room room3 = new Room(single, new ArrayList<OccupiedRoom>(), 102, status, true, true );
			Room room4 = new Room(single, new ArrayList<OccupiedRoom>(), 103, status, true, true );
			Room room5 = new Room(single, new ArrayList<OccupiedRoom>(), 104, status, true, true );
			Room room6 = new Room(single, new ArrayList<OccupiedRoom>(), 105, status, true, true );
			Room room7 = new Room(single, new ArrayList<OccupiedRoom>(), 106, status, true, true );
			Room room8 = new Room(single, new ArrayList<OccupiedRoom>(), 107, status, true, true );
			Room room9 = new Room(single, new ArrayList<OccupiedRoom>(), 108, status, true, true );
			Room room10 = new Room(single, new ArrayList<OccupiedRoom>(), 109, status, true, true );
			
			Room room11 = new Room(Double, new ArrayList<OccupiedRoom>(), 110, status, true, true );
			Room room12 = new Room(Double, new ArrayList<OccupiedRoom>(), 111, status, true, true );
			Room room13 = new Room(Double, new ArrayList<OccupiedRoom>(), 112, status, true, true );
			Room room14 = new Room(Double, new ArrayList<OccupiedRoom>(), 113, status, true, true );
			Room room15 = new Room(Double, new ArrayList<OccupiedRoom>(), 114, status, true, true );
			Room room16 = new Room(Double, new ArrayList<OccupiedRoom>(), 115, status, true, true );
			Room room17 = new Room(Double, new ArrayList<OccupiedRoom>(), 116, status, true, true );
			Room room18 = new Room(Double, new ArrayList<OccupiedRoom>(), 117, status, true, true );
			Room room19 = new Room(Double, new ArrayList<OccupiedRoom>(), 118, status, true, true );
			Room room20 = new Room(Double, new ArrayList<OccupiedRoom>(), 119, status, true, true );
			
			session.save(room1);
			session.save(room2);
			return room1;
		}
	}
	
	public Reservation createReservation() {
		try(Session session = sf.openSession()) {
			Guest guest = createGuest();
			Reservation reservation1 = new Reservation(guest, new ArrayList<OccupiedRoom>(), new ArrayList<ReservedRoom>(),new Date(0), new Date(0), "Made by something");
			return reservation1;
		}
	}
	
	public Guest createGuest() {
		try(Session session = sf.openSession()) {
			Guest guest = new Guest("Jonathan", "Bedolla", new Date(0), new ArrayList<Reservation>(),new ArrayList<HostedAt>());
			return guest;
		}
	}
	public OccupiedRoom createOccupiedRoom() {
		try(Session session = sf.openSession()) {
			OccupiedRoom room = new OccupiedRoom();
			return room;
		}
	}
	
}
