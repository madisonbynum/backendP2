package com.revature.enums;


public enum RoomType {
	SUITE ("A single room with a bed and sitting area.", 3),
	MASTER_SUITE ("A parlout or living room connected to one or more bedrooms.", 6),
	SINGLE ("A room assigned to one person. May have one or more beds.", 2),
	DOUBLE ("A room assigned to two people. May have one or more beds.", 4);
	
	private final String description;
	private final int maxCapacity;
	
	RoomType(String description, int maxCapacity) {
		this.description = description;
		this.maxCapacity = maxCapacity;
	}
	public String getDescription() {
		return description;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	
}
