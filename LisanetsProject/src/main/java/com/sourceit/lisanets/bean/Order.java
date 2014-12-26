package com.sourceit.lisanets.bean;

public class Order {
	
   private	int key;
   private  int order_id;
   private int guest_id;
   private String check_in;
   private String check_out;
	int room_number;
	String status;

	


	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getId_guest() {
		return  guest_id;
	}

	public void setId_guest(int id_guest) {
		this. guest_id = id_guest;
	}

	@Override
	public String toString() {
		return "Order [ order_id=" + order_id + ", guest_id=" + guest_id
				+ ", check_in=" + check_in + ", check_out=" + check_out
				+ ", room_number=" + room_number + ", status=" + status + "]";
	}


	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
