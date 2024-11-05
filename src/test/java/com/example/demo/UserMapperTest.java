package com.example.demo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@SpringBootTest
@Transactional
class UserMapperTest {

	@Autowired
	private UserMapper mapper;
	@Test
	void test() {
		var result = mapper.findAll();
		List<User> expected = List.of(new User(1L, "hoge"),
				new User(2L, "fuga"),
				new User(3L, "piyo"));
		assertThat(result.containsAll(expected) && expected.containsAll(result), is(true));
	}

}
