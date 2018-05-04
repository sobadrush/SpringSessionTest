package com.ctbc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String userAction = request.getParameter("userAction");
		System.out.println(">>>>>>>>> userAction = " + userAction + " <<<<<<<<<<");
		
		if ("doLogin".equals(userAction)) {
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			// ================= 驗證登入==================
			if ("驗證通過".equals("驗證通過")) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", "yes");
				session.setAttribute("loginName", loginName);
				session.setAttribute("password", password);
			}
			// ============================================
			response.sendRedirect(request.getContextPath() + "/show.jsp");
			return;
		}else if("doLogout".equals(userAction)){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		
	}
}
