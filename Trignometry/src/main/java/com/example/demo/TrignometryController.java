package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrignometryController {
	@Autowired
	private JdbcTemplate template;

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("calc")
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
	@RequestMapping("records")
	public String records(Model model) {
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
		return "records.jsp";
	}
	
//	HttpServletRequest
	@RequestMapping("demo")
	public String demo(HttpServletRequest req) {
		int a = Integer.parseInt(req.getParameter("angle"));
		String func = req.getParameter("func");
		System.out.println(func);
		int result = 0;
		
		HttpSession session = req.getSession();
		session.setAttribute("func", func);
		return "result.jsp";
	}

	
	
}
