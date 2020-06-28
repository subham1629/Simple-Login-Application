package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.PasswordChangeDAO;
import com.dao.UserDAO;

@WebServlet("/chng")
public class ChangePasswordServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		UserBean userbean=new UserBean();
		UserDAO userdao=new UserDAO();
		PrintWriter out = res.getWriter();
		
		userbean.setUserName(req.getParameter("username"));
		userbean.setPassword(req.getParameter("password"));
		
		if(userdao.checkUser(userbean).equals("Success")) {
			if(req.getParameter("new_password").equals(req.getParameter("new_password"))) {
				PasswordChangeDAO pdao=new PasswordChangeDAO();
				try {
					pdao.changePassword(req.getParameter("username"), req.getParameter("new_password"));
					out.print("Password Changed Successfully");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				out.print("Wrong new password");
			}
		}
		else {
			out.print("Old user id and password is wrong");
		}
	}
}
