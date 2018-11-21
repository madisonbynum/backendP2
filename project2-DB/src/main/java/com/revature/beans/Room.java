package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="room")
public class Room {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/*
	 * Maps a One-to-many relationship that relies on the 
	 * many-to-one side to propagate all entity state changes
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	private RoomType type;
	
	@OneToMany(mappedBy = "occupied_room",
			cascade = CascadeType.ALL)
	private List<OccupiedRoom> occupiedRooms = new ArrayList<>();
	
	@Column(name="number")
	private int number;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status; // possible enum
	
	@Column(name="smoke")
	private boolean smoke;

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

	public List<OccupiedRoom> getOccupiedRooms() {
		return occupiedRooms;
	}

	public void setOccupiedRooms(List<OccupiedRoom> occupiedRooms) {
		this.occupiedRooms = occupiedRooms;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((occupiedRooms == null) ? 0 : occupiedRooms.hashCode());
		result = prime * result + (smoke ? 1231 : 1237);
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
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (occupiedRooms == null) {
			if (other.occupiedRooms != null)
				return false;
		} else if (!occupiedRooms.equals(other.occupiedRooms))
			return false;
		if (smoke != other.smoke)
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
		return "Room [id=" + id + ", type=" + type + ", occupiedRooms=" + occupiedRooms + ", number=" + number
				+ ", name=" + name + ", status=" + status + ", smoke=" + smoke + "]";
	}

	public Room(RoomType type, List<OccupiedRoom> occupiedRooms, int number, String name, String status,
			boolean smoke) {
		super();
		this.type = type;
		this.occupiedRooms = occupiedRooms;
		this.number = number;
		this.name = name;
		this.status = status;
		this.smoke = smoke;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
//	@Column(name="room_type_id") // might not be needed
//	private int roomTypeId; // possible enum
	
	
}