package com.mybank.daos;

import java.util.List;

import com.mybank.models.Bank;

public interface Dao {
	Dao current = new BankDaoInMemory();
	
	Bank makeDeposit(Bank bank, double amount);
	
	Bank withdrawBalance(Bank bank, double amount);
	
	double calculateInterest(double amount, double rate, int year);
	
	List<Bank> viewAccount();
	
	void setCurrentChoice(int choice);
	
	int getCurrentChoice();
	
	void createAccount(Bank bank);
	
	void removeAccount(int bankNumber);
	
}
