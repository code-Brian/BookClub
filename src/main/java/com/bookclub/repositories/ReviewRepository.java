package com.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{
	public List<Review> findAll();
}
