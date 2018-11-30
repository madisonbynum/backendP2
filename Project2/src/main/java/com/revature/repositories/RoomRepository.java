package com.revature.repositories;

import java.net.HttpURLConnection;
import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.type.DateType;

import org.hibernate.query.Query;
import org.hibernate.type.DateType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Guest;
import com.revature.beans.HostedAt;
import com.revature.beans.OccupiedRoom;
import com.revature.beans.Reservation;
import com.revature.beans.ReservedRoom;
import com.revature.beans.Room;

@Repository
public class RoomRepository {
	
	@Autowired
	static SessionFactory sf;
	
	// need to add more methods here
	@Transactional
	public void insert(Reservation rs) {
		sf.getCurrentSession().persist(rs);
	}
	
	// Updates an element of the room that is targeted
	@Transactional
	public void update(Reservation rs) {
		sf.getCurrentSession().update(rs);
	}
	
	// Still trying to do more research on this.
	// Gets a list of rooms w/ the matching status, from the database.
	@Transactional
	public List<Room> get(String status) {
		String query = "Select * FROM room where status = :status";
		try (Session session = sf.openSession()){
			List<Room> rooms = session.createQuery(query, Room.class)
					.setParameter("status",status).getResultList();
			return rooms;
			
		}
	}
	
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

	public Room createRoom(Room room) {
		sf = setUpSessionFactory();
		try(Session session = sf.openSession()) {
			session.save(room);
			return room;
		}
	}

	public Reservation createReservation(Reservation res) {
		sf = setUpSessionFactory();
		try(Session session = sf.openSession()) {
			session.save(res);
			return res;
		}
	}


	public List<Room> getRooms() {
		sf = setUpSessionFactory();
		try(Session session = sf.openSession()) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = criteriaQuery.from(Room.class);
		criteriaQuery.select(root).where();
		Query<Room> query = session.createQuery(criteriaQuery);
		List<Room> roomModelList = query.getResultList();
		System.out.println(roomModelList);
		return roomModelList;
	}
  
  	public List<?> getReservationByDate(Date date) {
		sf = setUpSessionFactory();
		try(Session session = sf.openSession()){
			List<?> list = session.createQuery("select r from Reservation r where r.dateIn like :date_in")
					.setParameter("date_in", date)
					.getResultList();
			return list;
		}

	}
}
