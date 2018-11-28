package com.revature.repositories;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.revature.beans.Guest;

@Repository
public class GuestRepository {
	SessionFactory sf = setupSessionFactory();
	Logger log = Logger.getRootLogger();
	
	/**
	 * Meant as a way to extract the guest information
	 * @param sf
	 */
	
//	@Autowired
//	public GuestRepository(SessionFactory sf) {
//		super();
//		this.sf = sf;
//	}

	//Hibernate way to save a guest to the database
	public Guest save(Guest guest) {
		try(Session session = sf.openSession()){
			session.save(guest);
			return guest;
		}
	}
	
	public static SessionFactory setupSessionFactory() {
		Configuration configuration = new Configuration()
				.configure()
				.addAnnotatedClass(Guest.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
