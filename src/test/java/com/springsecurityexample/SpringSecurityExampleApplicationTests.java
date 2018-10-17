package com.springsecurityexample;

import com.springsecurityexample.model.Authority;
import com.springsecurityexample.model.User;
import com.springsecurityexample.repo.AuthorityRepository;
import com.springsecurityexample.repo.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityExampleApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;

	@Test
	public void contextLoads() {
	}

}
