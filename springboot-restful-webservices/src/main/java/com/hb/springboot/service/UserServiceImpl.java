package com.hb.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hb.springboot.dto.UserDTO;
import com.hb.springboot.entity.User;
import com.hb.springboot.exception.EmailAlreadyExistException;
import com.hb.springboot.exception.ResourceNotFoundException;
import com.hb.springboot.mapper.UserMapper;
import com.hb.springboot.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	// From Spring 4+ we don't need to add dependency @Autowired if default
	// constructor has single field
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		
		Optional<User> optionalUser = userRepository.findByUserEmail(userDto.getUserEmail());
		
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistException("Email already exist for User");
		} else {
			
		}

		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);
		UserDTO convertedUser = UserMapper.mapToUserDTO(savedUser);
		return convertedUser;
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", String.valueOf(id)));
		UserDTO userDto = UserMapper.mapToUserDTO(user);
		return userDto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> list = userRepository.findAll();

		return list.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUsers(UserDTO user) {
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", String.valueOf(user.getId())));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUserEmail(user.getUserEmail());
		User updatedUser = userRepository.save(existingUser);
		return UserMapper.mapToUserDTO(updatedUser);
	}

	@Override
	public void deleteUser(Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", String.valueOf(id)));
		
		userRepository.deleteById(id);
	}

}
