package com.sourceit.lisanets.bean;

public class Room {

	private int room_number;
	private int room_type;
	private int max_persons;

	@Override
	public String toString() {

		return "Room [room_number=" + room_number + ", room_type=" + room_type
				+ ", max_persons=" + max_persons + "]";
	}

	public Room(int room_number, int room_type, int max_persons) {
		super();
		this.room_number = room_number;
		this.room_type = room_type;
		this.max_persons = max_persons;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public int getRoom_type() {
		return room_type;
	}

	public void setRoom_type(int room_type) {
		this.room_type = room_type;
	}

	public int getMax_persons() {
		return max_persons;
	}

	public void setMax_persons(int max_persons) {
		this.max_persons = max_persons;
	}

}
