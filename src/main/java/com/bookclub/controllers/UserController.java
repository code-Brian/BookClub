package com.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
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
		if (userServ.checkLoginStatus(session)) {
			model.addAttribute("user", userServ.getOne((Long) session.getAttribute("userId")));
			model.addAttribute("allReviews", reviewServ.getAll());
			return "index.jsp";
		}else {
			return "redirect:/";
		}
	}

}
