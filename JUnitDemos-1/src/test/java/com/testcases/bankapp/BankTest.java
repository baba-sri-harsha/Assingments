package com.testcases.bankapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.acheron.training.Bank;
import com.calapp.Exceptions.ExceedingNumberException;
import com.calapp.Exceptions.NegativeValueException;

class BankTest {

	Bank bank = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(800000);
	}

	@AfterEach
	void tearDown() throws Exception {
		bank = null;
	}

	@Test
	@DisplayName("test for negative deposit")
	void depositTestNegativeDeposit() throws NegativeValueException {
		double amount = -5000;
		assertThrows(NegativeValueException.class, () -> bank.deposit(amount));

	}

	@Test
	@DisplayName("test for exceeding deposit")
	void depositTestExceedingNumber() throws ExceedingNumberException {
		double amount = 155000;
		assertThrows(ExceedingNumberException.class, () -> bank.deposit(amount));

	}

	@Test
	@DisplayName("test for positive  deposit  amount")
	void positiveDepositNumber() throws NegativeValueException, ExceedingNumberException {
		double amount = 5000;
		assertEquals(800000 + amount, bank.deposit(amount));

	}

	@Test
	@DisplayName("test for withdraw exceeding balance")
	void WithdrawNegitiveException() throws NegativeValueException {
		double amount = 155000;
		assertThrows(ExceedingNumberException.class, () -> bank.withdraw(amount));

	}

	@Test
	@DisplayName("test for entering  negitive  amount to withdraw")
	void NegitiveWithdrawException() throws NegativeValueException {
		double amount = -10000;
		assertThrows(NegativeValueException.class, () -> bank.withdraw(amount));

	}

	@Test
	@DisplayName("test for entering  amount to withdraw")
	void WithdrawException() throws ExceedingNumberException {
		double amount = 110000;
		assertThrows(ExceedingNumberException.class, () -> bank.withdraw(amount));

	}

	@Test
	@DisplayName("test for positive  withdraw  amount")
	void positiveWithdrawNumber() throws NegativeValueException, ExceedingNumberException {
		double amount = 5000;
		assertEquals(800000 - amount, bank.withdraw(amount));

	}

}
