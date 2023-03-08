package com.hb.springboot.service;

import java.util.List;

import com.hb.springboot.dto.UserDTO;
import com.hb.springboot.entity.User;

public interface UserService {

	public UserDTO createUser(UserDTO userDto);
	
	public UserDTO getUserById(Long id);
	
	public List<UserDTO> getAllUsers();
	
	public UserDTO updateUsers(UserDTO user);
	
	public void deleteUser(Long id);
}
