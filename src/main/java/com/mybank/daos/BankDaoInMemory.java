package com.mybank.daos;

import java.util.ArrayList;
import java.util.List;

import com.mybank.models.Bank;

public class BankDaoInMemory implements Dao {

	private static List<Bank> b = new ArrayList<>();
	private int currentChoice;

	@Override
	public Bank makeDeposit(int choice, double amount) {
		Bank bank = b.get(choice);
		b.get(choice).setBalance(bank.getBalance() + amount);
		b.add(choice, b.get(choice));
		b.remove(choice + 1);
		System.out.println("Deposit completed!");
		return b.get(choice);
	}

	@Override
	public Bank withdrawBalance(int choice, double amount) {
		Bank bank = b.get(choice);
		b.get(choice).setBalance(bank.getBalance() - amount);
		b.add(choice, b.get(choice));
		b.remove(choice + 1);
		System.out.println("Withdraw completed!");
		return b.get(choice);
	}

	@Override
	public double calculateInterest(double amount, double rate, int month) {
		return amount * Math.pow(1.0 + ((rate / 100.0) / 12), month);
	}

	@Override
	public List<Bank> viewAccount() {
		return b;
	}

	@Override
	public void createAccount(Bank bank) {
		System.out.println("A/an " + bank.getType().toLowerCase() + " bin has been created!");
		b.add(bank);
	}

	@Override
	public void removeAccount(int choice) {
		b.remove(choice);
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
