package com.tushar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterDTO {
	private int id;

	@NotBlank
	private String username;

	@NotBlank
	private String password;
}
