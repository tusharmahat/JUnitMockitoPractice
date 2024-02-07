package com.takeo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tushar.Application;
import com.tushar.dto.UserDetailsDTO;
import com.tushar.dto.UserRegisterDTO;
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

	// test userService getAll
	@Test
	public void getUsersTest() {
		//when(<mockmethod>).thenReturn(<return mock value>);
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User(1, "tushar", "12345"), new User(2, "tushar", "12345"), new User(2, "tushar", "12345"))
				.toList());
		List<UserDetailsDTO> users = userService.getAll();

		//assertEquals(<Expected value>,<mockMethod>)
		assertEquals(3, users.size());

	}

	@Test
	public void getUserTest() throws Exception {
		//when(<mockmethod>).thenReturn(<return mock value>);
		when(userRepo.findById(1)).thenReturn(Optional.of(new User(1, "tushar", "12345")));

		//call the mock the method
		UserDetailsDTO user = userService.get(1);

		//assertEquals(<Expected value>,<mockMethod>)
		assertEquals("tushar", user.getUsername());

	}

	@Test
	public void createTest() throws Exception {
		// Arrange: Set up mock behavior
		User user = new User(2, "tushar", "12345");
		UserRegisterDTO uDTO = new UserRegisterDTO();
		BeanUtils.copyProperties(user, uDTO);
		
		//when(<mockmethod>).thenReturn(<return mock value>);
		when(userRepo.save(user)).thenReturn(user);
		
		//assertEquals(<Expected value>,<mockMethod>)
		assertEquals("Saved User successfully", userService.create(uDTO));

	}

	@Test
	public void deleteTest() throws Exception {
		User user = new User(1, "tushar", "12345");
		
		//when(<mockmethod>).thenReturn(<return mock value>);
		when(userRepo.findById(user.getId())).thenReturn(Optional.of(user));
		
		userService.delete(user.getId());

		//this is for void return method
		//verify(<mockItem>, <times to mock>).<method to mock>
		verify(userRepo, times(1)).deleteById(user.getId());

	}
}
