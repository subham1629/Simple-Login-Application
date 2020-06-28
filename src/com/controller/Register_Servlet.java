package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.NewResgisterDAO;

@WebServlet("/register")
public class Register_Servlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		UserBean userbean=new UserBean();
		PrintWriter out = response.getWriter();
		userbean.setUserName(request.getParameter("username"));
		if(request.getParameter("password").equals(request.getParameter("conf_password"))){
			userbean.setPassword(request.getParameter("password"));
			NewResgisterDAO registerdao=new NewResgisterDAO();
			registerdao.registerUser(userbean);
			out.print("Registered Successfully");
		}
		else {
			out.print("Wrong Password");
		}
	}
}
