package com.hb.springboot.mapper;

import com.hb.springboot.dto.UserDTO;
import com.hb.springboot.entity.User;

public class UserMapper {

	public static UserDTO mapToUserDTO(User user) {
		UserDTO userDto = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getUserEmail());
		return userDto;
	}

	public static User mapToUser(UserDTO userDto) {
		User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getUserEmail());
		return user;
	}
}
