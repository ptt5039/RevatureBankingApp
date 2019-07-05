package com.mybank.prompts;

import java.util.Scanner;

import com.mybank.daos.Dao;

public class DepositPrompt implements Prompt {

	private Dao d = Dao.current;

	private Scanner sc = new Scanner(System.in);

	@Override
	public Prompt run() {
		String input;


		System.out.println("How many pieces of trash you want to put in:");
		input = sc.nextLine();
		try {
			double convert = Double.valueOf(input);

			if (convert > 0) {

				System.out.println("Are you sure you want to put " + convert + " piece(s) of trash in the bin? (y/n)");
				input = sc.nextLine();
				if (input.equalsIgnoreCase("y")) {
					d.makeDeposit(d.getCurrentChoice(), convert);
					return new WithdrawOrDepositPrompt();
				} else {
					if(input.equalsIgnoreCase("n"))
						return new WithdrawOrDepositPrompt();
					else {
						System.out.println("invalid input, return to trash bin view!");
						return new WithdrawOrDepositPrompt();
					}
						
					
				}
			} else {
				System.out.println("you can not put in a negative or zero number piece of trash, please try again!");
				return new DepositPrompt();

			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! You are so trash out, please try again");
			return new DepositPrompt();
		}
	}

}
