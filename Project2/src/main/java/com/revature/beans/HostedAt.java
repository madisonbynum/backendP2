package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hosted_at")
public class HostedAt {

	@Id
	@Column(name="hosted_at_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="guest_id")
	private Guest guests;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="occupied_room_id")
	private OccupiedRoom occupiedRoom;

	public Guest getGuests() {
		return guests;
	}

	public void setGuests(Guest guests) {
		this.guests = guests;
	}

	public OccupiedRoom getOccupiedRoom() {
		return occupiedRoom;
	}

	public void setOccupiedRoom(OccupiedRoom occupiedRoom) {
		this.occupiedRoom = occupiedRoom;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guests == null) ? 0 : guests.hashCode());
		result = prime * result + id;
		result = prime * result + ((occupiedRoom == null) ? 0 : occupiedRoom.hashCode());
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
		HostedAt other = (HostedAt) obj;
		if (guests == null) {
			if (other.guests != null)
				return false;
		} else if (!guests.equals(other.guests))
			return false;
		if (id != other.id)
			return false;
		if (occupiedRoom == null) {
			if (other.occupiedRoom != null)
				return false;
		} else if (!occupiedRoom.equals(other.occupiedRoom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HostedAt [id=" + id + ", guests=" + guests + ", occupiedRoom=" + occupiedRoom + "]";
	}

	public HostedAt(Guest guests, OccupiedRoom occupiedRoom) {
		super();
		this.guests = guests;
		this.occupiedRoom = occupiedRoom;
	}

	public HostedAt() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}