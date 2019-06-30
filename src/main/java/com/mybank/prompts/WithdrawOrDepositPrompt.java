package com.mybank.prompts;

import java.util.List;
import java.util.Scanner;

import com.mybank.daos.BankDaoInMemory;
import com.mybank.daos.Dao;
import com.mybank.models.Bank;

public class WithdrawOrDepositPrompt implements Prompt {
	
	Dao d = new BankDaoInMemory();
	List<Bank> banks;
	Scanner sc = new Scanner(System.in);

	@Override
	public Prompt run() {
		String input;
		banks = d.viewAccount();
		System.out.println("Your account: " + banks.get(d.getCurrentChoice()).toString());
		
		System.out.println("Choose what do you want to do with your trash bin.");
		System.out.println("1. Get the trash out");
		System.out.println("2. Put trash in the bin");
		System.out.println("3. Destroy this bin.");
		System.out.println("q to return to main menu.");
		input = sc.nextLine();

		switch (input) {
		case "1":
			System.out.println("How many pieces of trash you want to take out:");
			input = sc.nextLine();
			
			break;
		case "2":
			break;
		case "3":
			break;
		default:
			if (input.equalsIgnoreCase("q")) {
				return new HomePrompt();
			} else {
				System.out.println("You made an invalid choice, please try again.");
				return new WithdrawOrDepositPrompt().run();
			}

		}
		return null;
	}

}
