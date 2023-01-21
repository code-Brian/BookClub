package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Review;
import com.bookclub.repositories.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepo;
	
	public Review getOne(Long id) {
		Optional<Review> optReview = reviewRepo.findById(id);
		if(optReview.isPresent()) {
			return optReview.get();
		} else {	
			return null;
		}
	}
	
	public Review create(Review r) {
		return reviewRepo.save(r);
	}
	
	public Review update(Review r) {
		return reviewRepo.save(r);
	}
	
	public List<Review> getAll(){
		return reviewRepo.findAll();
	}
	
	public void delete(Review r) {
		reviewRepo.delete(r);
	}
}
