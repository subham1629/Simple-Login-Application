package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserBean;
import com.util.DBUtil;

public class NewResgisterDAO {
	public void registerUser(UserBean userBean){
		try{
			String sql = "insert into user_table values(?,?)";
			Connection con = DBUtil.getConnection();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userBean.getUserName());
			st.setString(2, userBean.getPassword());
			st.executeUpdate();
			st.close();
			con.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
