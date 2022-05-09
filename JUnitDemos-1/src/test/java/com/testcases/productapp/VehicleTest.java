package com.testcases.productapp;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.acheron.training.Student;

@Tag("vehicle-details")
public class VehicleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Tag("creation")
	void testAdd() {
		Student s1 = new Student();
		Student s2 = new Student();
		assertEquals(s1, s2);

	}

	// repetitive checks
	// @RepeatedTest(4)
	@RepeatedTest(value = 4, name = "{displayName} for {currentRepetition} out of {totalRepetition}")
	@DisplayName("Testing Numbers")
	void testName() {
		assertEquals(10, 10);
	}

	@RepeatedTest(value = 10, name = "{displayName} for {currentRepetition}")
	@DisplayName("Testing Temperatures")
	void testTemperature() {
		double num1 = Math.random();
		long val1 = Math.round(num1 * 10);
		System.out.println(num1 + val1);
		double num2 = Math.random();
		long val2 = Math.round(num2 * 10);
		System.out.println(num1 + val2);
		assertEquals(val1, val2);

	}

	@Test
	@Tag("check")
	void testCheck() {
		Student s1 = new Student();
		Student s3 = s1;
		assertSame(s1, s3);

	}

}
