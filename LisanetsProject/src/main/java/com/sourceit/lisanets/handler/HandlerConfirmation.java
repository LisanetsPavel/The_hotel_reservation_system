package com.sourceit.lisanets.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.lisanets.DAO.OrderDAO;
import com.sourceit.lisanets.DAO.RoomDAO;
import com.sourceit.lisanets.bean.Guest;
import com.sourceit.lisanets.bean.Order;
import com.sourceit.lisanets.bean.Room;

public class HandlerConfirmation implements Handler {
	private List<Integer> listSelectRooms;
	private Guest user;
	private String in;
	private String out;
	private List<Room> listFR;

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println(req.getSession().getAttribute("check_in"));
		in = (String) req.getSession().getAttribute("check_in");
		out = (String) req.getSession().getAttribute("check_out");
		user = (Guest) req.getSession().getAttribute("User");
		listSelectRooms = new ArrayList<Integer>();

		for (int i = 0; i < 6; i++) {
			String sel = req.getParameter("rooms" + i);
			if (!sel.equals("-")) {
				listSelectRooms.add(Integer.valueOf(sel));
			} else {
				listSelectRooms.add(0);
			}

		}

		List<Room> listRoom = getOrders();
		req.setAttribute("listRoom", listRoom);
		req.setAttribute("order",
				"Order number: " + new OrderDAO().getIDBook(user.getId_guest()));
		req.setAttribute("firstname", "First Name: " + user.getFirst_name());
		req.setAttribute("lastname", "Last Name: " + user.getLast_name());
		req.setAttribute("in", "Check-in date: " + in);
		req.setAttribute("out", "Check-out date: " + out);

		req.getRequestDispatcher("/WEB-INF/views/confirmation.jsp").forward(
				req, resp);

		for (Integer i : listSelectRooms)
			System.out.println(i);
		System.out.println(user);

		for (Room r : listRoom)
			System.out.println(r);
	}

	private List<Room> getOrders() {
		listFR = new RoomDAO().getFreeRoom(in, out);
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
			for (Room r : listFR) {
				if (r.getRoom_type() == type && r.getMax_persons() == max) {
					Order o = new Order();
					o.setId_guest(user.getId_guest());
					o.setCheck_in(in);
					o.setCheck_out(out);
					o.setRoom_number(r.getRoom_number());
					o.setStatus("new");
					listR.add(r);
					listFR.remove(r);

					new OrderDAO().add(o);

					break;
				}
			}

		}

	}

}
