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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="occupied_room")
public class OccupiedRoom {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="occupied_room_id")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="occupied_room_id")
	private List<HostedAt> hostedAt;
	
	@Column(name="check_in")
	private Date checkIn;
	
	@Column(name="check_out")
	private Date checkOut;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	public List<HostedAt> getHostedAt() {
		return hostedAt;
	}

	public void setHostedAt(List<HostedAt> hostedAt) {
		this.hostedAt = hostedAt;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result + ((hostedAt == null) ? 0 : hostedAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		OccupiedRoom other = (OccupiedRoom) obj;
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
			return false;
		if (hostedAt == null) {
			if (other.hostedAt != null)
				return false;
		} else if (!hostedAt.equals(other.hostedAt))
			return false;
		if (id != other.id)
			return false;
		if (reservation == null) {
			if (other.reservation != null)
				return false;
		} else if (!reservation.equals(other.reservation))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OccupiedRoom [id=" + id + ", hostedAt=" + hostedAt + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", room=" + room + ", reservation=" + reservation + "]";
	}

	public OccupiedRoom(List<HostedAt> hostedAt, Date checkIn, Date checkOut, Room room, Reservation reservation) {
		super();
		this.hostedAt = hostedAt;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.room = room;
		this.reservation = reservation;
	}

	public OccupiedRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
}
