package com.capgemini.repository;

import java.util.LinkedList;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;

public class BankRepositorySBI implements BankRepositoryInteface {

	LinkedList<Account> accounts=new LinkedList<>();
	
	
	/* (non-Javadoc)
	 * @see com.capgemini.repository.BankRepositoryInteface#createAccount(int, int)
	 */
	@Override
	public String createAccount(int accountNumber,int amount)
	{
		Account account = new Account(accountNumber,amount);
		
		accounts.add(account);
		
		return "account created successfully";
	}
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.repository.BankRepositoryInteface#withdrawAmount(int, int)
	 */
	@Override
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}

}
