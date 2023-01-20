package com.bookclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.repositories.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepo;

}
