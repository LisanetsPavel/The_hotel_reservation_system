package com.sourceit.lisanets.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.handler.Handler;
import com.sourceit.lisanets.handler.HandlerConfirmation;
import com.sourceit.lisanets.handler.HandlerError;
import com.sourceit.lisanets.handler.HandlerFreeRooms;
import com.sourceit.lisanets.handler.HandlerIndex;
import com.sourceit.lisanets.handler.HandlerLogin;
import com.sourceit.lisanets.handler.HandlerRegistration;
import com.sourceit.lisanets.handler.HandlerSelect;
import com.sourceit.lisanets.handler.HandlerThanks;

public class ServletController extends HttpServlet {

	private static final Logger logger = Logger.getLogger(ServletController.class);
	
	private Map<String, Handler> map;

	@Override
	public void init() throws ServletException {

		map = new HashMap<String, Handler>();
	
		map.put("http://localhost:8080/LisanetsProject",
				new HandlerIndex());
		
		map.put("http://localhost:8080/LisanetsProject/index",
				new HandlerIndex());
		map.put("http://localhost:8080/LisanetsProject/registration.do",
				new HandlerRegistration());
		map.put("http://localhost:8080/LisanetsProject/login.do",
				new HandlerLogin());
		map.put("http://localhost:8080/LisanetsProject/freeRooms.do",
				new HandlerFreeRooms());
		map.put("http://localhost:8080/LisanetsProject/confirmation.do",
				new HandlerConfirmation());
		map.put("http://localhost:8080/LisanetsProject/thanks.do",
				new HandlerThanks());
		map.put("http://localhost:8080/LisanetsProject/select.do",
				new HandlerSelect());
		map.put("http://localhost:8080/LisanetsProject/error.do",
				new HandlerError());
		
		super.init();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        
		
		Handler hand = map.get(req.getRequestURL().toString());
		hand.doAction(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		map.get(req.getRequestURL().toString()).doAction(req, resp);
	}

}
