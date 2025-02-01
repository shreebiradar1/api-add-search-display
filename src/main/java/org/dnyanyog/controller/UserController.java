package org.dnyanyog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.dto.User;
import org.dnyanyog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	User user;
//	@GetMapping("/name/{username}")
//	public String name(@PathVariable String username) {
//		return new UserService().getName(username);
//	}

	@PostMapping(path = "/save")
	public List<String> saveUser(@RequestBody User tempUser) {
		return new UserService().addUser(tempUser);
	}

	@GetMapping(path = "/display")
	public List<String> displayUser() {
		try {
			return new UserService().getUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping(path = "/search/{search}")
	public String searchUser(@PathVariable String search) {
		return new UserService().search(search);
	}

}
