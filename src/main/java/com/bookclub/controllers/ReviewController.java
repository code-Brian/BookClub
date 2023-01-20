package com.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookclub.services.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewServ;
	
	@GetMapping("/review")
	public String review() {
		return "review.jsp";
	}
}
