package com.acheron.training;

public class Calculator {
	
	public int add(int a, int b) {
		return (a+b);
	}
	
	public int product(int a, int b) {
		return (a*b);
	}
	
	public double positivedifference(double a, double  b) {
		if(a>b)
			return (a-b);
		else
			return -1*(a-b);
	}
	
	public String greetUser(String name) {
		return "Welcome "+name.toUpperCase();
	}
	
	
}
