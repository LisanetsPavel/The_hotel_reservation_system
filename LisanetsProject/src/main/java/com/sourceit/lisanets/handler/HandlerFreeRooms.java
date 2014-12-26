package com.sourceit.lisanets.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sourceit.lisanets.DAO.OrderDAO;
import com.sourceit.lisanets.DAO.RoomDAO;
import com.sourceit.lisanets.bean.FreeRoom;

public class HandlerFreeRooms implements Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		new OrderDAO().changeStatus();

		if (!checkCorrectDate(req)) {

			String json = new Gson().toJson("Error");

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(json);
			return;
		}

		String check_in = req.getParameter("yearIn") + "-"
				+ req.getParameter("monthIn") + "-" + req.getParameter("dayIn");
		String check_out = req.getParameter("yearOut") + "-"
				+ req.getParameter("monthOut") + "-"
				+ req.getParameter("dayOut");

		req.getSession().setAttribute("check_in", check_in);
		req.getSession().setAttribute("check_out", check_out);
		List<FreeRoom> listRoom = new RoomDAO().getCountFree(check_in,
				check_out);
		List<String> list = new ArrayList<String>();
		for (FreeRoom fr : listRoom)
			list.add(fr.toString());

		String json = new Gson().toJson(list);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);

	}

	private boolean checkCorrectDate(HttpServletRequest req) {
		Calendar dateIn = new GregorianCalendar(Integer.parseInt(req
				.getParameter("yearIn")), Integer.parseInt(req
				.getParameter("monthIn")), Integer.parseInt(req
				.getParameter("dayIn")));
		Calendar dateOut = new GregorianCalendar(Integer.parseInt(req
				.getParameter("yearOut")), Integer.parseInt(req
				.getParameter("monthOut")), Integer.parseInt(req
				.getParameter("dayOut")));
		if (dateIn.getTimeInMillis() > dateOut.getTimeInMillis())
			return false;
		return true;
	}

}
