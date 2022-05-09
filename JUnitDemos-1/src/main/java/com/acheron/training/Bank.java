package com.acheron.training;

import com.calapp.Exceptions.ExceedingNumberException;
import com.calapp.Exceptions.NegativeValueException;

public class Bank {

	double balance;

	public Bank(double balance) {
		super();
		this.balance = balance;
	}

	public double deposit(double amount) throws NegativeValueException, ExceedingNumberException {

		if (amount <= 0) {
			throw new NegativeValueException();
		} else if (amount > 10000) {
			throw new ExceedingNumberException();
		} else {
			return balance + amount;
		}

	}

	public double withdraw(double amount) throws NegativeValueException, ExceedingNumberException {
		if (amount > 10000) {
			throw new ExceedingNumberException();
		} else if (amount > balance) {
			throw new ExceedingNumberException();
		} else if (amount < 0) {
			throw new NegativeValueException();
		} else {
			return balance - amount;
		}
	}
}
