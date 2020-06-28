package com.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDAO;

@WebServlet("/login")
public class Login_Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean userBean = new UserBean();
		userBean.setUserName(userName);
		userBean.setPassword(password);
		UserDAO dao = new UserDAO();
		String status = dao.checkUser(userBean);
		if(status.equals("Success"))
		{
			out.print("Login Successful");
		}
		else{
			out.print("Login Failed");
		}
		out.close();
	}
}
