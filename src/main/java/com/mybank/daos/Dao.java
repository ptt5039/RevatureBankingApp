package com.mybank.daos;

import java.util.List;

import com.mybank.models.Bank;

public interface Dao {
	Dao current = new BankDaoInMemory();
	
	Bank makeDeposit(int choice, double amount);
	
	Bank withdrawBalance(int choice, double amount);
	
	double calculateInterest(double amount, double rate, int month);
	
	List<Bank> viewAccount();
	
	void setCurrentChoice(int choice);
	
	int getCurrentChoice();
	
	void createAccount(Bank bank);
	
	void removeAccount(int bankNumber);
	
}
