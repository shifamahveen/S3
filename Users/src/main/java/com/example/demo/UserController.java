package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	private JdbcTemplate db;
	
	@RequestMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("create")
	public String create(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("email") String email, Model model) {
		String sql = "insert into users (name, phone, email) values (?, ?, ?)";
		db.update(sql, name, phone, email);
		
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone", phone);
		return "result.jsp";
	}
	
}
