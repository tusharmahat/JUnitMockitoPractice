package com.takeo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tushar.Application;
import com.tushar.dto.UserDetailsDTO;
import com.tushar.entity.User;
import com.tushar.repo.UserRepo;
import com.tushar.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ApplicationTests {
	@Autowired
	UserService userService;

	@MockBean
	UserRepo userRepo;


	//test userService getAll
	@Test
	public void getUsersTest() {
		// Arrange: Set up mock behavior
	    when(userRepo.findAll())
	            .thenReturn(Stream.of(
	                    new User(1, "tushar", "12345"),
	                    new User(2, "tushar", "12345"),
	                    new User(2, "tushar", "12345"))
	                    .toList());

	    // Act: Invoke the method under test
	    List<UserDetailsDTO> users = userService.getAll();

	    // Assert: Verify the outcome
	    assertEquals(2, users.size()); // Check if the correct number of users is returned
	 
	}
}
