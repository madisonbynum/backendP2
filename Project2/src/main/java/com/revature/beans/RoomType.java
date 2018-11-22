package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room_type")
public class RoomType {
	
	// This column name may need to change
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// Maps the room_type to rooms
	@OneToMany(mappedBy = "room_type",
			cascade = CascadeType.ALL)
	private List<Room> rooms = new ArrayList<>();
	
	@OneToMany(mappedBy = "room_type",
			cascade = CascadeType.ALL)
	private List<ReservedRoom> reservedRoom = new ArrayList<>();
	
	@Column(name="description")
	private String description;
	
	@Column(name="max_capacity")
	private int maxCapacity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<ReservedRoom> getReservedRoom() {
		return reservedRoom;
	}

	public void setReservedRoom(List<ReservedRoom> reservedRoom) {
		this.reservedRoom = reservedRoom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + maxCapacity;
		result = prime * result + ((reservedRoom == null) ? 0 : reservedRoom.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
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
		RoomType other = (RoomType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (maxCapacity != other.maxCapacity)
			return false;
		if (reservedRoom == null) {
			if (other.reservedRoom != null)
				return false;
		} else if (!reservedRoom.equals(other.reservedRoom))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoomType [id=" + id + ", rooms=" + rooms + ", reservedRoom=" + reservedRoom + ", description="
				+ description + ", maxCapacity=" + maxCapacity + "]";
	}

	public RoomType(List<Room> rooms, List<ReservedRoom> reservedRoom, String description, int maxCapacity) {
		super();
		this.rooms = rooms;
		this.reservedRoom = reservedRoom;
		this.description = description;
		this.maxCapacity = maxCapacity;
	}

	public RoomType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
