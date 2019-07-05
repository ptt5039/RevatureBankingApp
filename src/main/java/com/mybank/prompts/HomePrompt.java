package com.mybank.prompts;

import java.util.Scanner;


public class HomePrompt implements Prompt {
	
	private Scanner sc = new Scanner(System.in);
	

	@Override
	public Prompt run() {
		while(true) {
		String input;
		System.out.println("\nEnter 1 to view all trash bins.");
		System.out.println("Enter 2 to create a trash bin.");
		System.out.println("Enter 3 to calculate amount of bacterials that will grow over the time.");
		input = sc.nextLine();
		switch (input) {
		case "1":
			return new ViewAccountPrompt();
		case "2":
			return new CreateAccountPrompt();
		case "3":
			return new InterestCalculationPrompt();
		default:
			System.out.println("You are so trash out, please try again!");
		}
	}
	}

}
