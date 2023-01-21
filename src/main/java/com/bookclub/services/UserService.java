package com.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User getOne(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		} else {
			return null;
		}
	}
	
	public User create(User u) {
		return userRepo.save(u);
	}
	
	public User register(User createdUser, BindingResult result) {
		if(!createdUser.getPassword().equals(createdUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword","Match", "Passwords must match!");
			return null;
		}
		
		Optional<User> userEmail = userRepo.findByEmail(createdUser.getEmail());
		if(userEmail.isPresent()) {
			System.out.println("Duplicate email found!");
			result.rejectValue("email", "In Use", "Email in use!");
			return null;
		}
		
		if(!result.hasErrors()) {
			String hashed = BCrypt.hashpw(createdUser.getPassword(), BCrypt.gensalt());
			createdUser.setPassword(hashed);
			return this.create(createdUser);
		}

		return null;
	}
	
	public User login(LoginUser logUser, BindingResult result) {
		Optional<User> user = userRepo.findByEmail(logUser.getEmail());
		// This checks to see if the user exists in the DB
		// BCrypt then checks the input password instead of using the creatpw function, which would add a unique salt
		if(user.isPresent() && BCrypt.checkpw(logUser.getPassword(), user.get().getPassword())) {
			return user.get();
		}
		result.rejectValue("password", "Invalid","Invalid credentials!");
		return null;
	}
}
