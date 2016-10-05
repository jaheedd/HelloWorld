package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public interface AccountService {

	String createAccount(int accountNumber, int amount);

	int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException;
}
