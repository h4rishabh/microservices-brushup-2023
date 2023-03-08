package com.hb.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.hb.springboot.dto.UserDTO;
import com.hb.springboot.exception.CustomErrorDetails;
import com.hb.springboot.exception.EmailAlreadyExistException;
import com.hb.springboot.exception.ResourceNotFoundException;
import com.hb.springboot.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

	private UserService userSercive;

	// build create user REST API
	// http://localhost:8080/api/users
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO savedUser = userSercive.createUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// build get user REST API
	// http://localhost:8080/api/users/4
	@GetMapping("{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long userId) {
		UserDTO userDto = userSercive.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	// build get all users REST API
	// http://localhost:8080/api/users
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsersList() {
		List<UserDTO> users = userSercive.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// build update user REST API
	// http://localhost:8080/api/users/{id}
	@PutMapping("{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @PathVariable("id") Long userId, @RequestBody UserDTO userDto) {
		userDto.setId(userId);
		UserDTO updatedUser = userSercive.updateUsers(userDto);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// build delete user REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userSercive.deleteUser(id);
		return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<CustomErrorDetails> handledResourceNotFoundException(ResourceNotFoundException exception,
//			WebRequest webRequest) {
//
//		CustomErrorDetails errorDetails = new CustomErrorDetails(
//
//				LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false), "USER_NOT_FOUND");
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//
//	}

//	@ExceptionHandler(EmailAlreadyExistException.class)
//	public ResponseEntity<CustomErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException exception,
//			WebRequest webRequest) {
//
//		CustomErrorDetails errorDetails = new CustomErrorDetails(LocalDateTime.now(), exception.getMessage(),
//				webRequest.getDescription(false), "EMAIL_ALREADY_EXIST");
//		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//
//	}
}
