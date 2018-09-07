package com.ctbc.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctbc.utils.VerifyCodeUtils;

@WebServlet("/GenVerifyCodeServlet")
public class GenVerifyCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==================== GenVerifyCodeServlet 產生隨機驗證碼 =====================");
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");

		// 生成隨機字符串  
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		System.out.println("生成隨機字符串 verifyCode : " + verifyCode);
		
		// 存入session  
		req.getSession().setAttribute("CODE", verifyCode.toLowerCase());

		//生成圖片  
		int width = 100;//寬
		int height = 40;//高  
		ServletOutputStream os = resp.getOutputStream();
		VerifyCodeUtils.outputImage(width, height, os, verifyCode);
		
		HttpSession session = req.getSession();
		Enumeration<?> enumeration = session.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			Object val = session.getAttribute(name);
			System.out.println(name  + "<===>" + val);
		}
	}

}
