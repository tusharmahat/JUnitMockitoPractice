package com.tushar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.dto.UserDetailsDTO;
import com.tushar.dto.UserRegisterDTO;
import com.tushar.entity.User;
import com.tushar.repo.UserRepo;
import com.tushar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<UserDetailsDTO> getAll() {
		List<User> users = userRepo.findAll();
		List<UserDetailsDTO> usersDetails = new ArrayList<>();
		users.forEach(u -> {
			UserDetailsDTO uDTO = new UserDetailsDTO();
			BeanUtils.copyProperties(u, uDTO);
			usersDetails.add(uDTO);

		});
		return usersDetails;
	}

	@Override
	public String create(UserRegisterDTO userDto) {
		User newUser = new User();
		BeanUtils.copyProperties(userDto, newUser);
		System.out.println(userDto.getUsername());
		User savedUser = userRepo.save(newUser);
		if (savedUser != null) {
			return "Saved User successfully";
		}
		return "Could not save User";
	}

	@Override
	public UserDetailsDTO get(int id) throws Exception {
		User existingUser = userRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
		UserDetailsDTO userDto = new UserDetailsDTO();
		BeanUtils.copyProperties(existingUser, userDto);
		return userDto;
	}

	@Override
	public String delete(int id) throws Exception {
		userRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
		userRepo.deleteById(id);
		return "Deleted";
	}

	@Override
	public String update(UserRegisterDTO userDto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
