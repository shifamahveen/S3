package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrignometryController {
	@Autowired
	private JdbcTemplate template;

	@GetMapping("/")
	public String home(HttpServletRequest req) {
		if(isLoggedIn(req)) {
			return "index.jsp";
		} else {
			return "login.jsp";
		}
	}
	
	@PostMapping("calc")
	public String calc(@RequestParam("angle") String angle, @RequestParam("func") String func, Model model) {
		float deg = Integer.parseInt(angle);
		double result = 0;
		double rad = Math.toRadians(deg);
		
		switch(func) {
			case "sin": {
				result = Math.sin(rad);
				break;
			}
			case "cos": {
				result = Math.cos(rad);
				break;
			}
			case "tan": {
				result = Math.tan(rad);
				break;
			}
			case "cot": {
				result = 1/Math.tan(rad);
				break;
			}
			case "cosec": {
				result = 1/Math.sin(rad);
				break;
			}
			case "sec": {
				result = 1/Math.cos(rad);
				break;
			}
			default : {
				result = 0;
			}
		}
		
		String sql = "insert into trig (angle, func, result) values (?, ?, ?)";
		template.update(sql, angle, func, result);
		
		model.addAttribute("angle", angle);
		model.addAttribute("func", func);
		model.addAttribute("result", result);
		return "result.jsp";
	}
	
	//	get all records
	@GetMapping("records")
	public String records(Model model, HttpServletRequest req) {
		if(isLoggedIn(req)) {
			String phone = (String) req.getSession().getAttribute("phone");
			String sql = "select name from users where phone = ?";
			String name = template.queryForObject(sql, String.class, phone);
			
			// get role and determine their admin access			
			String sql1 = "select role from users where phone = ?";
			String role = template.queryForObject(sql1, String.class, phone);
			boolean userType;
			if(role.equals("admin")) {
				userType = true;
			} else {
				userType = false;
			}
			
			List<Trig> records = template.query(
					"select * from trig",
					(rs, rowNum) -> new Trig (
						rs.getInt("id"),
						rs.getInt("angle"),
						rs.getString("func"),
						rs.getDouble("result")
					)
				);	
				model.addAttribute("records", records);
				model.addAttribute("name", name);
				model.addAttribute("userType", userType);
				return "records.jsp";
		} else {
			return "login.jsp";
		}
		
	}
	
	@GetMapping("sort")
	public String sort(Model model, @RequestParam("orderFunc") String orderFunc) {
		String sql;
		
		if(orderFunc.equals("asc")) {
			sql = "select * from trig order by angle asc";
		} else {
			sql = "select * from trig order by angle desc";
		}
		
		List<Trig> records = template.query(
			sql,
			(rs, rowNum) -> new Trig (
				rs.getInt("id"),
				rs.getInt("angle"),
				rs.getString("func"),
				rs.getDouble("result")
			)
		);	
		
		model.addAttribute("records", records);
		return "records.jsp";
	}
	
	@GetMapping("search")
	public String search(Model model, @RequestParam("text") String text) {
		@SuppressWarnings("deprecation")
		List<Trig> records = template.query(
			"select * from trig where func like ?",
			new String[] {"%" + text + "%"},
			(rs, rowNum) -> new Trig (
				rs.getInt("id"),
				rs.getInt("angle"),
				rs.getString("func"),
				rs.getDouble("result")
			)
		);	
		
		model.addAttribute("records", records);
		return "records.jsp";
	}
	
	@GetMapping("edit") 
	public String edit(@RequestParam("id") int id, Model model) {
		@SuppressWarnings("deprecation")
		Trig record = template.queryForObject(
				"select * from trig where id = ?",
				new Object[]{id},
				(rs, rowNum) -> new Trig (
					rs.getInt("id"),
					rs.getInt("angle"),
					rs.getString("func"),
					rs.getDouble("result")
				)
			);	
		System.out.println(record);
		model.addAttribute("record", record);
		return "edit.jsp";
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute Trig trig) {
		String sql = "update trig set angle = ?, func = ?, result = ? where id = ?";
		int status = template.update(sql, trig.getAngle(), trig.getFunc(), trig.getResult(), trig.getId());
		
		if(status > 0) {
			return "redirect:/records";
		} else {
			return "error.jsp";
		}
	}
	
	@PostMapping("delete/{id}")
	public String destroy(@PathVariable int id) {
		int status  = template.update("delete from trig where id = ?", id);
		if(status > 0) {
			return "redirect:/records";
		} else {
			return "error.jsp";
		}
	}
	
	@GetMapping("login")
	public String login() {
		return "login.jsp";
	}
	
	@PostMapping("login")
	public String loginUser(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletRequest req, Model model) {
		if(isRegistered(phone, password)) {
//			get role of user
			String sql = "select role from users where phone = ?";
			String role = template.queryForObject(sql, String.class, phone);
			
			req.getSession().setAttribute("phone", phone);
			req.getSession().setAttribute("role", role);

			return "redirect:/records";
		} else {
			model.addAttribute("error", "User not registered");
			return "error.jsp";
		}
	}
	
	public boolean isRegistered(String phone, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String sql = "select password from users where phone = ?";
		String storedPassword = template.queryForObject(sql, String.class,phone);
		
		return encoder.matches(password, storedPassword);
	}
	
	public boolean isLoggedIn(HttpServletRequest req) {
		String status = (String) req.getSession().getAttribute("phone");
		
		return status != null;
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String status = (String) session.getAttribute("phone");
		
		if(status != null) {
			session.invalidate();
			return "login.jsp";
		} else {
			session.setAttribute("error", "User not logged in");
			return "error.jsp";
		}
	}
	
	@GetMapping("admin")
	public String admin(Model model, HttpServletRequest req) {
		if(!isAdmin(req)) {
			model.addAttribute("error", "You dont have admin access");
			return "error.jsp";
		}
		
		List<User> users = template.query(
				"select * from users",
				(rs, rowNum) -> new User (
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("gender"),
						rs.getString("location")
					)				
				);
				
		model.addAttribute("users", users);
		return "users.jsp";
	}
	
	public boolean isAdmin(HttpServletRequest req) {
		String role = (String) req.getSession().getAttribute("role");
		return "admin".equals(role);
	}
}
