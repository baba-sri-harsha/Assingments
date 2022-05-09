package com.testcases.studentapp;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.acheron.training.Student;
import com.calapp.Exceptions.ExceedingNumberException;
import com.calapp.Exceptions.NegativeValueException;

class StudentTest {
	Student student= null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student= new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student= null;
	}

	@Test
	@DisplayName("Testing positive values")
	void testTotakMarks() throws NegativeValueException, ExceedingNumberException {
		assertEquals(200,student.totalMarks(75, 75,50),"values dont match - expected 200");
	}
	
	@Test
	@DisplayName("Testing negitive values")
	void testNegitiveTotalMarks() {
		assertThrows(NegativeValueException.class,()->student.totalMarks(-75,50,40));
	}
	
	@Test
	@DisplayName("Testing greater than 100")
	void testGreaterTotalMarks() {
		assertThrows(ExceedingNumberException.class,()->student.totalMarks(200,150,200));
	}
	
	
	@Test
	@DisplayName("Testing grades A")
	void testGradeA() throws ExceedingNumberException, NegativeValueException {
		int[] marks= {90,90,95};
		String grade= student.getGrade(marks);
		assertEquals("A",grade,"Expecting A");
	}
	
	
	@Test
	@DisplayName("Testing grades B")
	void testGradeB() throws ExceedingNumberException , NegativeValueException {
		int[] marks= {85,80,90};
		String grade= student.getGrade(marks);
		assertEquals("B",grade,"Expecting B");
	}
	
	@Test
	@DisplayName("Testing grades C")
	void testGradeC() throws ExceedingNumberException , NegativeValueException {
		int[] marks= {80,80,75};
		String grade= student.getGrade(marks);
		assertEquals("C",grade,"Expecting C");
	}
	@Test
	@DisplayName("Testing grades D")
	void testGradeD() throws ExceedingNumberException, NegativeValueException {
		int[] marks= {60,60,65};
		String grade= student.getGrade(marks);
		assertEquals("D",grade,"Expecting D");
	}
	@Test
	@DisplayName("Testing grades E")
	void testGradeE() throws ExceedingNumberException, NegativeValueException {
		int[] marks= {50,50,55};
		String grade= student.getGrade(marks);
		assertEquals("E",grade,"Expecting E");
	}
	
	@Test
	@DisplayName("Testing grades Fail")
	void testGradeF() throws ExceedingNumberException , NegativeValueException {
		int[] marks= {45,45,45};
		String grade= student.getGrade(marks);
		assertEquals("Fail",grade,"Expecting F");
	}
	
	
	@Test
	@DisplayName("Testing negative value")
	void testGradeNeg()  throws NegativeValueException{
		int[] marks= {-45,45,-45};
		assertThrows(NegativeValueException.class,()->student.getGrade(marks));
	}
	
	@Test
	@DisplayName("Testing Exceeding value")
	void testGrade() throws ExceedingNumberException {
		int[] marks= {105,105,105};
		assertThrows(ExceedingNumberException.class,()->student.getGrade(marks));
	}
	
	
	@Test
	@DisplayName("Testing Null array")
	void testGradeNull() throws NullPointerException, ExceedingNumberException, NegativeValueException {
		int[] marks= null;
		assertEquals("Done",student.getGrade(marks));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
