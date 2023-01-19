package com.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
