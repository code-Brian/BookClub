package com.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{

}
