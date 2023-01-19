package com.bookclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

}
