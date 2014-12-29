package com.sourceit.lisanets.handler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.DAO.GuestDAO;
import com.sourceit.lisanets.bean.Guest;
import com.sourceit.lisanets.servlet.ServletController;

public class HandlerLogin implements Handler {

	private static final Logger logger = Logger.getLogger(HandlerLogin.class);
	
	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		Guest user = new GuestDAO().getGuest(request.getParameter("login"));
		if (user.getPassword() != null) {

			if (user.getPassword().equals(request.getParameter("password"))) {
				logger.info("Succesed enter" + user.toString());
				request.getSession().setAttribute("User", user);
				request.getRequestDispatcher("/WEB-INF/views/Select-date.jsp")
						.forward(request, responce);

			} else {
				logger.info("Password incorrect" + user.toString());
				request.setAttribute("text", "Password incorrect");
				request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(
						request, responce);
			}
		} else {
			logger.info("Such an email not registered" + user.toString());
			request.setAttribute("text", "Such an email not registered");
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,
					responce);
		}

	}

}
