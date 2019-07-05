package com.mybank.prompts;

import java.util.List;
import java.util.Scanner;

import com.mybank.daos.Dao;
import com.mybank.models.Bank;

public class WithdrawOrDepositPrompt implements Prompt {

	private Dao d = Dao.current;
	private List<Bank> banks;
	private Bank bank;
	private Scanner sc = new Scanner(System.in);

	@Override
	public Prompt run() {
		String input;
		banks = d.viewAccount();
		bank = banks.get(d.getCurrentChoice());
		System.out.println("Your account: " + bank.toString());

		System.out.println("Choose what do you want to do with your trash bin.");
		System.out.println("1. Get the trash out");
		System.out.println("2. Put trash in the bin");
		System.out.println("3. Destroy this bin.");
		System.out.println("q to return to main menu.");
		input = sc.nextLine();

		switch (input) {
		case "1":
			return new WithdrawPrompt();
		case "2":
			return new DepositPrompt();
		case "3":
			return new RemoveAccountPrompt();
		default:
			if (input.equalsIgnoreCase("q")) {
				return new HomePrompt();
			} else {
				System.out.println("Invalid input, please try again!");
				return new WithdrawOrDepositPrompt();
			}
		}
	}

}
