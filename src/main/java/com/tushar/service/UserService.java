package com.tushar.service;

import java.util.List;

import com.tushar.dto.UserDetailsDTO;
import com.tushar.dto.UserRegisterDTO;

public interface UserService {
	
	List<UserDetailsDTO> getAll();
	String create(UserRegisterDTO userDto);

}
