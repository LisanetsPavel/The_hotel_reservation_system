package com.sourceit.lisanets.bean;

public class FreeRoom {

	private int count;
    private	int room_type;
	private int max_persons;

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
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
	
	@Override
	public String toString() {
		String type = "";
		String lux = "LUX";
		String standart ="Standart";
		String vip = "VIP";
		if (room_type == 1) type = standart;
		else if(room_type == 2) type = lux;
		else if (room_type == 3) type = vip;
		
		return ""+ count + " rooms of "+  type + " type" + ", max_persons: " + max_persons ;
	}
	
	
	
}
