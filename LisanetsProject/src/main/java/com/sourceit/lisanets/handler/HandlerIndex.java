package com.sourceit.lisanets.handler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sourceit.lisanets.DAO.GuestDAO;
import com.sourceit.lisanets.bean.Guest;

public class HandlerIndex  implements Handler  {

      @Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
	
		  
		
		  request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			
			
		
		}
     
	}


