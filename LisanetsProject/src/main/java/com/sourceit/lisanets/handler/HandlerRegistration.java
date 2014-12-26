package com.sourceit.lisanets.handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.lisanets.DAO.GuestDAO;
import com.sourceit.lisanets.bean.Guest;

public class HandlerRegistration implements Handler {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		Guest guest = new Guest();
		guest.setFirst_name(request.getParameter("FirstName"));
		guest.setLast_name(request.getParameter("LastName"));
		guest.setPhone(request.getParameter("Phone"));
		guest.setPassword(request.getParameter("Password"));
		guest.setEmail(request.getParameter("Email"));
     try{    new GuestDAO().add(guest);}
     catch (SQLException e){
    	 request.setAttribute("text", "Error: This email is registrated already");
    	 request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, responce);
          return;
     }
      request.setAttribute("text", "Registratoin succesed");
     request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, responce);
	}
}
