package com.sourceit.lisanets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.lisanets.DAO.OrderDAO;
import com.sourceit.lisanets.bean.Guest;

public class HandlerThanks implements Handler {

	@Override
	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	System.out.println("thanks started");
		Guest user = (Guest) request.getSession().getAttribute("User");
		new OrderDAO().changeStatus(user.getId_guest());
        request.getRequestDispatcher("/WEB-INF/views/thanks.jsp").forward(request, response);
	}

}
