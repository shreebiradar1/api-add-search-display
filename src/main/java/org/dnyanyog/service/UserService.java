package org.dnyanyog.service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DatabaseUtil;
import org.dnyanyog.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	// Adding User Logic
	public List<String> addUser(User user) {
		ArrayList<String> names = new ArrayList<>();

		String query = "Insert into user (username, email, mobile) " + "Values ('" + user.getName() + "', '"
				+ user.getEmail() + "', '" + user.getMobile() + "');";

		try {
			Statement statement = DatabaseUtil.userConnection().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return names;
	}

	// Search User Logic
	public String search(String username) {
		String query = "Select * from user where username = '" + username + "';";

		try {
			ResultSet result = DatabaseUtil.executeUser(query);
			result.next();

			String userData = "Username: " + result.getString(1) + ", Email: " + result.getString(2) + ", Mobile: "
					+ result.getString(3);

			return userData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Something is off";
		}
	}

	// Display all user
	public List<String> getUser() throws SQLException {
		String query = "Select * from user";

		ArrayList<String> names = new ArrayList<>();

		ResultSet rs = DatabaseUtil.executeUser(query);
		while (rs.next()) {
			for (int i = 1; i < 4; i++) {
				names.add(rs.getString(i));
			}

		}

		return names;

	}
}
