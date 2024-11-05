package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@Controller
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/home")
	public String moveToHome(Model model) {
		List<User> users = userMapper.findAll();
		model.addAttribute("users", users);
		return "homeView";
	}
}
