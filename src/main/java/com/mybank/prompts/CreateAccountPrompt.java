package com.mybank.prompts;

import java.util.Scanner;

import com.mybank.daos.Dao;
import com.mybank.models.Bank;

public class CreateAccountPrompt implements Prompt {

	private Dao d = Dao.current;
	private Scanner sc = new Scanner(System.in);

	@Override
	public Prompt run() {
		String input;
		double amount = 0;
		System.out.println("Select the trash type to create the bin for them or enter q to return to main menu at anytime:");
		System.out.println("1. Organic");
		System.out.println("2. Recycle");
		input = sc.nextLine();

		switch (input) {
		case "1":

			do {
				System.out.println("Please input your initial trash you want to put in the bin.");
				input = sc.nextLine();
				try {
					amount = Double.valueOf(input);
					if (amount >= 0) {
						d.createAccount(new Bank("Organic", amount));
						return new HomePrompt();
					} else {
						System.out.println("Your input is not valid. Please try again");
					}

				} catch (NumberFormatException e) {
					if (input.equalsIgnoreCase("q")) {
						return new HomePrompt();
					} else {
						System.out.println("invalid input , please try again:");
					}
				}
			} while (amount == 0);
		case "2":
			do {
				System.out.println("Please input your initial trash you want to put in the bin.");
				input = sc.nextLine();
			try {
					amount = Double.valueOf(input);
					if (amount >= 0) {
						d.createAccount(new Bank("Recycle", amount));
						return new HomePrompt();
					} else {
						System.out.println("Your input is not valid. Please try again");
					}
			} catch (NumberFormatException e) {
				if (input.equalsIgnoreCase("q")) {
					return new HomePrompt();
				} else {
					System.out.println("invalid input , please try again:");
				}
			}
			}while(amount == 0);

		default:
			if (input.equalsIgnoreCase("q")) {
				return new HomePrompt();
			} else {
				System.out.println("invalid input , please try again:");
				return new CreateAccountPrompt();
			}
		}

	}

}
