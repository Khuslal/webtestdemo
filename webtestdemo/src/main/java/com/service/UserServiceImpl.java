package com.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.DB;
import com.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public void userSignup(User user)  {
		
		String sql = "insert into webtestdemo (fname, lname, username, password) values (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = DB.getDBCon().prepareStatement(sql);
			pstmt = DB.getDBCon().prepareStatement(sql);
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean userLogin(String un, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
