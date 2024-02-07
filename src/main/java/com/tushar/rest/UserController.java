package com.tushar.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.dto.UserDetailsDTO;
import com.tushar.dto.UserRegisterDTO;
import com.tushar.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<UserDetailsDTO> getUsers() {
		return userService.getAll();
	}

	@PostMapping("")
	public ResponseEntity<Map<String, String>> registerUser(@Valid @RequestBody UserRegisterDTO userDto) {
		String registerUser = userService.create(userDto);
		Map<String, String> response = new HashMap<>();
		response.put("Message", registerUser);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
