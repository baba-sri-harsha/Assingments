package com.testcases.calapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acheron.training.Calculator;

public class CalculatorTest {

	Calculator cal = null;

	@BeforeAll
	public static void init() {
		System.out.println("runs before all the test cases");
	}

	@BeforeEach
	public void setup() {
		cal = new Calculator();
		System.out.println("runs before each test case");
	}

	@Test
	public void testProduct() {
		int actualResult = cal.product(20, 40);
		assertEquals(800, actualResult, "the expected result is 60");
	}

	@Test
	public void positivetestdifference() {
		double actualResult = cal.positivedifference(20, 40);
		assertEquals(20, actualResult, "the expected result is 60");
	}

	@Test
	public void testgreetUser() {
		assertEquals("Welcome BABA", cal.greetUser("baba"));

	}

	@Test
	public void testadd() {
		int actualResult = cal.add(20, 30);
		assertEquals(50, actualResult);

	}

	@AfterEach
	public void tearup() {
		cal = null;
		System.out.println("runs after each test case");
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("runs after all the test cases");
	}

}
