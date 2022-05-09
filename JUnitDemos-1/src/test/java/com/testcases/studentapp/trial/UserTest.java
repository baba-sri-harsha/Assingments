package com.testcases.studentapp.trial;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.acheron.training.User;

public class UserTest {
	User user=null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user=new User();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		user=null;
	}

	@Test
	void testGreet() {
		assertEquals("Have a great day", user.greet());
	}
	
	@ParameterizedTest
	@ValueSource(strings={"Great Day","Have a great day","Good day"})
	void tesGreet(String message) {
		assertEquals(message,user.greet());
	}
	
	@ParameterizedTest
	@ValueSource(ints={2,190,100})
	void testCheck(int num) {
		assertTrue(num<=user.check());
//		assertEquals(num,user.check());
	}
}
