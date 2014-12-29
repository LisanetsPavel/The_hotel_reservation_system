package com.sourceit.lisanets.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.DAO.OrderDAO;
import com.sourceit.lisanets.DAO.RoomDAO;
import com.sourceit.lisanets.bean.Guest;
import com.sourceit.lisanets.bean.Order;
import com.sourceit.lisanets.bean.Room;
import com.sourceit.lisanets.servlet.ServletController;

public class HandlerConfirmation implements Handler {
	private final static int  COUNT_SELECTS = 6;
	private List<Integer> listSelectRooms;
	private Guest user;
	private String dateIn;
	private String dateOut;
	private List<Room> freeRooms;
	private static final Logger logger = Logger.getLogger(HandlerConfirmation.class);
	
	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
	
		dateIn = (String) req.getSession().getAttribute("check_in");
		dateOut = (String) req.getSession().getAttribute("check_out");
		user = (Guest) req.getSession().getAttribute("User");
		listSelectRooms = new ArrayList<Integer>();

		for (int i = 0; i < COUNT_SELECTS; i++) {
			String sel = req.getParameter("rooms" + i);
			if (!sel.equals("-")) {
				listSelectRooms.add(Integer.valueOf(sel));
			} else {
				listSelectRooms.add(0);
			}

		}

		List<Room> listRoom = getOrders();
		logger.info("Booked rooms:" + Arrays.toString(listRoom.toArray()) );
		req.setAttribute("listRoom", listRoom);
		req.setAttribute("order",
				"Order number: " + new OrderDAO().getIDBook(user.getIdGuest()));
		req.setAttribute("firstname", "First Name: " + user.getFirstName());
		req.setAttribute("lastname", "Last Name: " + user.getLastName());
		req.setAttribute("in", "Check-in date: " + dateIn);
		req.setAttribute("out", "Check-out date: " + dateOut);

		req.getRequestDispatcher("/WEB-INF/views/confirmation.jsp").forward(
				req, resp);

		
	}

	private List<Room> getOrders() {
		freeRooms = new RoomDAO().getFreeRoom(dateIn, dateOut);
		List<Room> listR = new ArrayList<Room>();
		createOrders(1, 1, listSelectRooms.get(0), listR);
		createOrders(1, 2, listSelectRooms.get(1), listR);
		createOrders(2, 1, listSelectRooms.get(2), listR);
		createOrders(2, 2, listSelectRooms.get(3), listR);
		createOrders(3, 1, listSelectRooms.get(4), listR);
		createOrders(3, 2, listSelectRooms.get(5), listR);

		return listR;
	}

	private void createOrders(int type, int max, int iter, List<Room> listR) {

		for (int i = 0; i < iter; i++) {
			for (Room r : freeRooms) {
				if (r.getRoomType() == type && r.getMaxPerson() == max) {
					Order o = new Order();
					o.setGuestId(user.getIdGuest());
					o.setCheckIn(dateIn);
					o.setCheckOut(dateOut);
					o.setRoomNumber(r.getRoomNumber());
					o.setStatus("new");
					listR.add(r);
					freeRooms.remove(r);

					new OrderDAO().add(o);

					break;
				}
			}

		}

	}

}
