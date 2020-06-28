package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;
import com.util.DBUtil;

public class PasswordChangeDAO {
	public void changePassword(String username,String password) throws SQLException {
		String sql="update user_table set password=? where username=?";
		Connection con=DBUtil.getConnection();
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, password);
		st.setString(2, username);
		st.executeUpdate();
		con.close();
		st.close();
		
	}
}
