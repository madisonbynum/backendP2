package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.enums.ReservedRoomStatus;
import com.revature.enums.RoomType;
@Entity
@Table(name = "reserved_room")
public class ReservedRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reserved_room_id")
	private int id;
	
	private int numberOfRooms;
	
	private RoomType type; // enum
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;
	
	
	// Going to have to be enumerated w/..
	// ..ReservedRoomStatus enum
	private ReservedRoomStatus status;


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}


	public RoomType getType() {
		return type;
	}


	public void setType(RoomType type) {
		this.type = type;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public ReservedRoomStatus getStatus() {
		return status;
	}


	public void setStatus(ReservedRoomStatus status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numberOfRooms;
		result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ReservedRoom other = (ReservedRoom) obj;
		if (id != other.id)
			return false;
		if (numberOfRooms != other.numberOfRooms)
			return false;
		if (reservation == null) {
			if (other.reservation != null)
				return false;
		} else if (!reservation.equals(other.reservation))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}


	public ReservedRoom(int numberOfRooms, RoomType type, Reservation reservation, ReservedRoomStatus status) {
		super();
		this.numberOfRooms = numberOfRooms;
		this.type = type;
		this.reservation = reservation;
		this.status = status;
	}


	public ReservedRoom() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	
	
	
}
