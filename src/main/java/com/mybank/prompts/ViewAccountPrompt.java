package com.mybank.prompts;

import java.util.List;
import java.util.Scanner;

import com.mybank.daos.Dao;
import com.mybank.models.Bank;

public class ViewAccountPrompt implements Prompt {

	private Scanner sc = new Scanner(System.in);
	private Dao d = Dao.current;
	private List<Bank> banks;

	@Override
	public Prompt run() {
		String input;
		banks = d.viewAccount();
		int counter = 0;

		if (!banks.isEmpty()) {
			for (Bank bank : banks) {
				counter++;
				System.out.println((counter) + ". Trash bin type: " + bank.getType() + ", number of trash piece: "
						+ bank.getBalance());
			}

			System.out.println("\nEnter trash bin's number you want to use or q to return to main menu.");

			input = sc.nextLine();

			try {
				int convert = Integer.valueOf(input);
				if (convert <= banks.size()) {
					if (convert > 0) {
						d.setCurrentChoice(convert - 1);
						return new WithdrawOrDepositPrompt();
					} else if (convert <= 0) {
						System.out.println("You made an invalid choice, return to the main menu!");
						return new HomePrompt();
					}
				} else {
					System.out.println("You made an invalid choice, please try again!");
					return new ViewAccountPrompt();
				}
			} catch (NumberFormatException e) {
				{
					if (input.equalsIgnoreCase("q")) {
						return new HomePrompt();
					} else {
						System.out.println("You made an invalid choice, please try again!");
						return new ViewAccountPrompt();
					}
				}
			}
		} else {
			System.out.println("You have no trash bin, please create one!");
			return new HomePrompt();
		}
		return null;

	}

}
