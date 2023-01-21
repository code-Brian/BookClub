package com.bookclub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByEmail(String email);
}
