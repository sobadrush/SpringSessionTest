package com.ctbc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -8455306719565291102L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		request.getSession().setAttribute("login", true);
		request.getSession().setAttribute(loginName, password);
		response.sendRedirect(request.getContextPath() + "/show.jsp");
	}
}
