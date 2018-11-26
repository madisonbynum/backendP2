package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReservedRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	private RoomType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;
	
	@Column(name="number_of_rooms")
	private int numberOfRooms;
	
//	@Column(name="room_type_id") // might not be needed
//	private int roomTypeId;
	
//	@Column(name="reservation_id") // might not be needed
//	private int reservationId;
	
	// Going to have to be enumerated w/..
	// ..ReservedRoomStatus enum
	@Column(name="status") 
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReservedRoom [id=" + id + ", type=" + type + ", reservation=" + reservation + ", numberOfRooms="
				+ numberOfRooms + ", status=" + status + "]";
	}

	public ReservedRoom(RoomType type, Reservation reservation, int numberOfRooms, String status) {
		super();
		this.type = type;
		this.reservation = reservation;
		this.numberOfRooms = numberOfRooms;
		this.status = status;
	}

	public ReservedRoom() {
		super();
	}
	
}
