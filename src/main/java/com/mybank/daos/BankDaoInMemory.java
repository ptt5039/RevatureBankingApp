package com.mybank.daos;

import java.util.ArrayList;
import java.util.List;

import com.mybank.models.Bank;

public class BankDaoInMemory implements Dao {
	
	private List<Bank> b;
	private int currentChoice;
	
	public BankDaoInMemory() {
		b = new ArrayList<>();
		b.add(new Bank("Recycle", 1000.0));
		b.add(new Bank("Organic", 2000.0));
	}
	
	@Override
	public Bank makeDeposit(Bank bank, double amount) {
		
		return null;
	}

	@Override
	public Bank withdrawBalance(Bank bank, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateInterest(double amount, double rate, int year) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Bank> viewAccount() {
		return b; 
	}

	@Override
	public void createAccount(Bank bank) {
		b.add(bank);
	}

	@Override
	public void removeAccount(int bankNumber) {
		b.remove(bankNumber);

	}

	@Override
	public int getCurrentChoice() {
		return currentChoice;
	}
	
	@Override
	public void setCurrentChoice(int currentChoice) {
		this.currentChoice = currentChoice;
	}
	
	

}
