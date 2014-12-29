package com.sourceit.lisanets.bean;

public class Room {

	private int roomNumber;
	private int roomType;
	private int maxPerson;

	public Room(int room_number, int room_type, int max_persons) {
		super();
		this.roomNumber = room_number;
		this.roomType = room_type;
		this.maxPerson = max_persons;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int room_number) {
		this.roomNumber = room_number;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int room_type) {
		this.roomType = room_type;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int max_persons) {
		this.maxPerson = max_persons;
	}

	@Override
	public String toString() {

		return "Room [room_number=" + roomNumber + ", room_type=" + roomType
				+ ", max_persons=" + maxPerson + "]";
	}
}
