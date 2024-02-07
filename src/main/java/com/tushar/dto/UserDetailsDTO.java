package com.tushar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDetailsDTO {
	private int id;

	@NotBlank
	private String username;
}
