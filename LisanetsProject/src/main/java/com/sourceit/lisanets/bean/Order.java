package com.sourceit.lisanets.bean;

public class Order {

	private int key;
	private int orderId;
	private int guestId;
	private String checkIn;
	private String checkOut;
	private int roomNumber;
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int order_id) {
		this.orderId = order_id;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int id_guest) {
		this.guestId = id_guest;
	}

	@Override
	public String toString() {
		return "Order [ order_id=" + orderId + ", guest_id=" + guestId
				+ ", check_in=" + checkIn + ", check_out=" + checkOut
				+ ", room_number=" + roomNumber + ", status=" + status + "]";
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String check_in) {
		this.checkIn = check_in;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String check_out) {
		this.checkOut = check_out;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int room_number) {
		this.roomNumber = room_number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
