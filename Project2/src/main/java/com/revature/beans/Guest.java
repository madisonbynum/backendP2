package com.revature.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="guest_id")
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private Date memberSince;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="guest_id")
	private List<Reservation> reservations;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="guest_id")
	private List<HostedAt> hostedAts;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<HostedAt> getHostedAts() {
		return hostedAts;
	}

	public void setHostedAts(List<HostedAt> hostedAts) {
		this.hostedAts = hostedAts;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hostedAts == null) ? 0 : hostedAts.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((memberSince == null) ? 0 : memberSince.hashCode());
		result = prime * result + ((reservations == null) ? 0 : reservations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hostedAts == null) {
			if (other.hostedAts != null)
				return false;
		} else if (!hostedAts.equals(other.hostedAts))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (memberSince == null) {
			if (other.memberSince != null)
				return false;
		} else if (!memberSince.equals(other.memberSince))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", memberSince="
				+ memberSince + ", reservations=" + reservations + ", hostedAts=" + hostedAts + "]";
	}

	public Guest(String firstName, String lastName, Date memberSince, List<Reservation> reservations,
			List<HostedAt> hostedAts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.memberSince = memberSince;
		this.reservations = reservations;
		this.hostedAts = hostedAts;
	}

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	

}