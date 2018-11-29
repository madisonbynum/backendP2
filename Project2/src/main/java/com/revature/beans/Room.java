package com.revature.beans;

import java.util.ArrayList;
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

import com.revature.enums.ReservedRoomStatus;
import com.revature.enums.RoomType;

@Entity
@Table(name="room")
public class Room {

	@Id
	@Column(name="room_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	/*
	 * Maps a One-to-many relationship that relies on the 
	 * many-to-one side to propagate all entity state changes
	 */

	private RoomType type;
	
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	private List<OccupiedRoom> occupiedRooms = new ArrayList<>();
	
	@Column(name="number")
	private int number;
	
	@Column(name="status")
	private ReservedRoomStatus status; // possible enum
	
	@Column(name="smoke")
	private boolean smoke;
	
	@Column(name="ocean_side_view")
	private boolean oceanSideView;

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

	public ReservedRoomStatus getStatus() {
		return status;
	}

	public void setStatus(ReservedRoomStatus status) {
		this.status = status;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	public boolean isOceanSideView() {
		return oceanSideView;
	}

	public void setOceanSideView(boolean oceanSideView) {
		this.oceanSideView = oceanSideView;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((occupiedRooms == null) ? 0 : occupiedRooms.hashCode());
		result = prime * result + (oceanSideView ? 1231 : 1237);
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
		if (number != other.number)
			return false;
		if (occupiedRooms == null) {
			if (other.occupiedRooms != null)
				return false;
		} else if (!occupiedRooms.equals(other.occupiedRooms))
			return false;
		if (oceanSideView != other.oceanSideView)
			return false;
		if (smoke != other.smoke)
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", type=" + type + ", occupiedRooms=" + occupiedRooms + ", number=" + number
				+ ", status=" + status + ", smoke=" + smoke + ", oceanSideView=" + oceanSideView + "]";
	}

	public Room(RoomType type, List<OccupiedRoom> occupiedRooms, int number, ReservedRoomStatus status, boolean smoke,
			boolean oceanSideView) {
		super();
		this.type = type;
		this.occupiedRooms = occupiedRooms;
		this.number = number;
		this.status = status;
		this.smoke = smoke;
		this.oceanSideView = oceanSideView;
	}
	
	

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	 
}