package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
//	display form
	@RequestMapping("/")
	public String home() {
		return "form.jsp";
	}
	
//	calculator operation logic	
	@RequestMapping("calc")
	public String calculate(@RequestParam("a") String a, @RequestParam("b") String b, @RequestParam("opr") String opr, Model model) {
		int result = 0;
		int num1 = Integer.parseInt(a); 	// converting url param from string to int
		int num2 = Integer.parseInt(b);
		
		switch(opr) {
			case "add": {
				result = num1 + num2;
				break;
			}
			case "sub": {
				result = num1 - num2;
				break;
			}
			case "mul": {
				result = num1 * num2;
				break;
			}
			case "div": {
				if(num2 != 0) {
					result = num1 / num2;
				} else {
					result = 0;
				}
				break;
			}
			default: result = 0;
		}
		
		System.out.println(result);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("opr", opr);
		model.addAttribute("result", result);
		return "result.jsp";
	}

	@RequestMapping("about") // -> 127.0.0.1:8085/about || -> localhost:8085/about
	public String home(@RequestParam("name") String username, @RequestParam("batch") String batch, Model model) {
		System.out.println(username);
		model.addAttribute("fname", username);
		model.addAttribute("batch", batch);
		return "about.jsp";
	}
	
	@RequestMapping("demo") // localhost:8085/demo
	public String demo(@RequestParam("batch") String batch, HttpSession session) {
		session.setAttribute("batch", batch);
		System.out.println(batch);
		return "batch.jsp";
	}

}