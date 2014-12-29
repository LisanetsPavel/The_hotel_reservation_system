package com.sourceit.lisanets.handler;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {

	public void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

}
