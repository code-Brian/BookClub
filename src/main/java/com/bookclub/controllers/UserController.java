package com.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookclub.services.ReviewService;
import com.bookclub.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userServ;
	
	@Autowired
	ReviewService reviewServ;
	
	@GetMapping("/dashboard")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOne(userId));
		model.addAttribute("allReviews", reviewServ.getAll());
		
		return "index.jsp";
	}

}
