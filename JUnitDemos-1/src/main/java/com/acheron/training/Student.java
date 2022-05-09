package com.acheron.training;

import com.calapp.Exceptions.ExceedingNumberException;
import com.calapp.Exceptions.NegativeValueException;

public class Student {

	public int totalMarks(int marks1, int marks2, int marks3) throws NegativeValueException, ExceedingNumberException {

		if (marks1 < 0 || marks2 < 0 || marks3 < 0) {
			throw new NegativeValueException("negitive values are not allowed");
		} else if (marks1 > 100 || marks2 > 100 || marks3 > 100) {
			throw new ExceedingNumberException("out of 100 entered");
		}
		return marks1 + marks2 + marks3;

	}

	public String getGrade(int[] marks) throws ExceedingNumberException, NegativeValueException {
		int sum = 0;
		if (marks != null) {
			for (int mark : marks) {
				if (mark > 100 || mark < 0)
					throw new ExceedingNumberException();
				sum += mark;
			}

			int average = sum / marks.length;
			if (average > 90)
				return "A";
			if (average >= 80 && average < 90)
				return "B";
			if (average >= 70 && average < 80)
				return "C";
			if (average >= 60 && average < 70)
				return "D";
			if (average >= 50 && average < 60)
				return "E";
			if (average < 50)
				return "Fail";
		}
		return "Done";

	}

}
