package com.tushar.service;

import java.util.List;

import com.tushar.dto.UserDetailsDTO;
import com.tushar.dto.UserRegisterDTO;

public interface UserService {

	List<UserDetailsDTO> getAll();

	UserDetailsDTO get(int id) throws Exception;

	String create(UserRegisterDTO userDto);

	String delete(int id) throws Exception;

	String update(UserRegisterDTO userDto, int id);

}
