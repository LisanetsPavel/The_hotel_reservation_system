package com.sourceit.lisanets.handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.DAO.GuestDAO;
import com.sourceit.lisanets.bean.Guest;
import com.sourceit.lisanets.exceptions.DataBaseExceprion;

public class HandlerRegistration implements Handler {

	private static final Logger logger = Logger
			.getLogger(HandlerRegistration.class);

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {

		if (!checkEmail(request.getParameter("Email"))) {
			request.setAttribute("text",
					"Error: This email is registrated already");
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(
					request, responce);
			return;

		}

		Guest guest = new Guest();
		guest.setFirstName(request.getParameter("FirstName"));
		guest.setLastName(request.getParameter("LastName"));
		guest.setPhone(request.getParameter("Phone"));
		guest.setPassword(request.getParameter("Password"));
		guest.setEmail(request.getParameter("Email"));
		logger.info("Registrated:" + guest.toString());
		try {
			new GuestDAO().add(guest);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			 throw new DataBaseExceprion(e);
		}
		request.setAttribute("text", "Registratoin succesed");
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(
				request, responce);
	}

	private boolean checkEmail(String email) {

		Guest guest = new GuestDAO().getGuest(email);
		if (guest.getEmail() == null)
			return true;

		return false;
	}

}
