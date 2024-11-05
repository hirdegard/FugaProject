package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private UserMapper userMapper;
	
	@Test
	void testMoveToHome() throws Exception {
		//userMapperの挙動
		List<User> expected = List.of(new User(1L, "hoge"),
				new User(2L, "fuga"),
				new User(3L, "piyo"));
		when(userMapper.findAll()).thenReturn(expected);
		
		mock.perform(get("/home"))
		.andExpect(status().isOk())
		.andExpect(view().name("homeView"))
		.andExpect(model().attribute("users", expected));
	}

}
