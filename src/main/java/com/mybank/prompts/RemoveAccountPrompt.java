package com.mybank.prompts;

import java.util.Scanner;

import com.mybank.daos.Dao;

public class RemoveAccountPrompt implements Prompt{
	
	private Dao d = Dao.current;
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public Prompt run() {
		String input;
		System.out.println("Are you sure you want to destroy this trash bin? (y/n)");
		input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			d.removeAccount(d.getCurrentChoice());
			System.out.println("Your trash bin has been destroyed!");
			return new HomePrompt();
		}else {
			if(input.equalsIgnoreCase("n")) {
				return new WithdrawOrDepositPrompt();
			}else {
				System.out.println("That was an invalid input, please try again!");
				return new RemoveAccountPrompt();
			}
		}
	}
	
}
