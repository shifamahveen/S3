package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String home() {
		return "about.jsp";
	}

	@RequestMapping("about") // -> 127.0.0.1:8085/about || -> localhost:8085/about
	public String home(@RequestParam("name") String username, @RequestParam("batch") String batch, Model model) {
		System.out.println(username);
		model.addAttribute("fname", username);
		model.addAttribute("batch", batch);
		return "about.jsp";
	}
}