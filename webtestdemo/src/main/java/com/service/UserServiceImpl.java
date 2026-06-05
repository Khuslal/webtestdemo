package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.User;

public class UserServiceImpl implements UserService {

	// user signup
	@Override
	public void userSignup(User user) {

		String sql = "insert into webtestdemo (fname, lname, username, password) values (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = DB.getDBCon().prepareStatement(sql);
			pstmt.setString(1, user.getFname());
			pstmt.setString(2, user.getLname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// user login
	@Override
	public boolean userLogin(String un, String pwd) {
		String sql = "select * from webtestdemo where username = ? and password = ?";
		try {
			PreparedStatement pstmt = DB.getDBCon().prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// List
	@Override
	public List<User> getAllUsers() {
		List <User> ulist = new ArrayList();
		String sql = "select * from webtestdemo";
		try {
			PreparedStatement pstmt = DB.getDBCon().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				ulist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}

}
