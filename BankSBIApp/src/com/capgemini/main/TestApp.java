package com.capgemini.main;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.repository.BankRepositoryInteface;
import com.capgemini.repository.BankRepositorySBI;

public class TestApp {

	public static void main(String[] args) {
		BankRepositoryInteface bank = new BankRepositorySBI();
		
		System.out.println(bank.createAccount(101, 3000));
		System.out.println(bank.createAccount(102, 3000));
		
		try
		{
			System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
		}catch(InvalidAccountNumberException i)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ibe){
			System.out.println("insufficient balance");
		}

	}
}
