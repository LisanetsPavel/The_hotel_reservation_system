package com.sourceit.lisanets.bean;



public class FreeRoom {
    
     
     private int count;
	private int roomType;
	private int maxPerson;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRoom_type() {
		return roomType;
	}

	public void setRoom_type(int roomType) {
		this.roomType = roomType;
	}

	public int getMax_persons() {
		return maxPerson;
	}

	public void setMax_persons(int max_persons) {
		this.maxPerson = max_persons;
	}
  
	@Override
	public String toString() {
		String type = "";
		String lux = "LUX";
		String standart = "Standart";
		String vip = "VIP";
		if (roomType == 1)
			type = standart;
		else if (roomType == 2)
			type = lux;
		else if (roomType == 3)
			type = vip;

		return  count + " rooms of " + type + " type" + ", max_persons: "
				+ maxPerson;
	}

}
