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

	private static final long serialVersionUID = 1L;
	private static final String CORRECT_EMAIL = "fuckyou@ctbcbank.com";
	private static final String CORRECT_PASSWORD = "qweasdzxc123";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		//----------------------------------------------
		
		HttpSession session = req.getSession();
		String actionName = req.getParameter("action");
		switch (actionName) {
			case "doLogin":
				System.out.println(">>>>>> doLogin <<<<<<");
				if (checkLoginInfo(req, session) == true) {
					System.out.println(String.format("%s", "=== 比對驗證碼-成功 ==="));
					req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req, resp);
					session.removeAttribute("CODE");
					System.out.println(">>>登入成功，移除Session中的驗證碼<<<");
				} else {
					System.out.println(String.format("%s", "=== 比對驗證碼-失敗 ==="));
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				}
				return;
			default:
				System.out.println(">>>>>> 無此actionName <<<<<");
				resp.sendRedirect(req.getContextPath() + "/error.jsp");
				return;
		}
	}

	private boolean checkLoginInfo(HttpServletRequest req, HttpSession session ) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String verifyCode = req.getParameter("verifyCode");
		String verifyCodeInSession = (String) session.getAttribute("CODE");
		System.out.println(" 正確驗證碼：" + verifyCodeInSession);
		boolean result = verifyCodeInSession.equalsIgnoreCase(verifyCode) && 
						 CORRECT_EMAIL.equalsIgnoreCase(email) &&
						 CORRECT_PASSWORD.equalsIgnoreCase(password);
		return result;
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
