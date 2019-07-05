package com.mybank.prompts;

import java.util.List;
import java.util.Scanner;

import com.mybank.daos.Dao;
import com.mybank.models.Bank;

public class WithdrawPrompt implements Prompt {

	private Dao d = Dao.current;
	private List<Bank> banks;
	private Bank bank;

	private Scanner sc = new Scanner(System.in);

	@Override
	public Prompt run() {
		String input;

		banks = d.viewAccount();
		bank = banks.get(d.getCurrentChoice());

		System.out.println("How many pieces of trash you want to take out:");
		input = sc.nextLine();
		try {
			double convert = Double.valueOf(input);

			if (convert <= bank.getBalance()) {
				if (convert <= 0) {
					System.out.println("Invalid input, please try again!");
					return new WithdrawPrompt();
				} else {
					System.out.println("Are you sure you want to take out " + convert + " piece(s) of trash? (y/n)");
					input = sc.nextLine();
					if (input.equalsIgnoreCase("y")) {
						d.withdrawBalance(d.getCurrentChoice(), convert);
						return new WithdrawOrDepositPrompt();
					} else {
						return new WithdrawOrDepositPrompt();
					}
				}
			} else {
				System.out.println("You don't have enough trash in the bin!");
				return new WithdrawOrDepositPrompt();

			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! You are so trash out, please try again");
			return new WithdrawOrDepositPrompt();
		}
	}

}
