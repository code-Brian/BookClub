package com.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookclub.models.Review;
import com.bookclub.services.ReviewService;
import com.bookclub.services.UserService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewService reviewServ;
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/create")
	public String review(@ModelAttribute("review") Review review, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOne(userId));
		return "review.jsp";
	}
	
	@PostMapping("/create")
	public String review(@Valid @ModelAttribute("review") Review review, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.getOne(userId));
			return "review.jsp";
		}
		reviewServ.create(review);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String review(@PathVariable("id") Long reviewId, Model model, HttpSession session) {
		model.addAttribute("currentUser", session.getAttribute("userId"));
		model.addAttribute("review", reviewServ.getOne(reviewId));
		return "reviewShow.jsp";
	}
}
