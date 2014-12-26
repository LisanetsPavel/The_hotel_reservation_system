package com.sourceit.lisanets.handler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.lisanets.DAO.GuestDAO;
import com.sourceit.lisanets.bean.Guest;

public class HandlerLogin implements Handler {

	@Override
	public void doAction(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Guest user = new GuestDAO().getGuest(req.getParameter("login"));
		if (user.getPassword() != null) {

			if (user.getPassword().equals(req.getParameter("password"))) {
				req.getSession().setAttribute("User", user);
				req.getRequestDispatcher("/WEB-INF/views/Select-date.jsp")
						.forward(req, resp);

			} else {
				req.setAttribute("text", "Password incorrect");
				req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(
						req, resp);
			}
		} else {
			req.setAttribute("text", "Such an email not registered");
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,
					resp);
		}

	}

}
