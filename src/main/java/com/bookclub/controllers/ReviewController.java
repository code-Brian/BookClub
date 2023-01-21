package com.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}/update")
	public String reviewUpdate(@ModelAttribute("review") Review review, @PathVariable("id") Long reviewId, HttpSession session, Model model) {
		Review editReview = reviewServ.getOne(reviewId);
		System.out.println("The title of the review is: " + editReview.getTitle());
		if(userServ.checkLoginStatus(session) && session.getAttribute("userId").equals(editReview.getUser().getId())) {
			model.addAttribute("review", reviewServ.getOne(reviewId));
			return "reviewUpdate.jsp";
		}else {
			return "redirect:/dashboard";
		}
	}
	
	@PutMapping("/{id}/update")
	public String review(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, @PathVariable("id") Long reviewId) {
		if(!result.hasErrors()) {
			review.setId(reviewId);
			reviewServ.update(review);
			return "redirect:/review/{id}";
		} else {
			model.addAttribute("review", reviewServ.getOne(reviewId));
			return "reviewUpdate.jsp";
		}
	}
	
	@DeleteMapping("/{id}/delete")
	public String review(@PathVariable("id") Long reviewId, HttpSession session) {
		Review deleteReview = reviewServ.getOne(reviewId);
		if(userServ.checkLoginStatus(session) && session.getAttribute("userId").equals(deleteReview.getUser().getId())) {
			reviewServ.delete(deleteReview);
			return "redirect:/dashboard";
		} else {
			return "redirect:/dashboard";
		}
	}
}
