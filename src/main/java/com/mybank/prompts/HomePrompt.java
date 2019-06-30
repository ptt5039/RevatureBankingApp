package com.mybank.prompts;

import java.util.Scanner;

import com.mybank.daos.BankDaoInMemory;
import com.mybank.daos.Dao;


public class HomePrompt implements Prompt {
	Scanner sc = new Scanner(System.in);
	Dao d = new BankDaoInMemory();

	@Override
	public Prompt run() {
		String input;
		System.out.println("Enter 1 to view all trash bins.");
		System.out.println("Enter 2 to create a trash bin.");
		System.out.println("Enter 3 to remove a trash bin.");
		System.out.println("Enter 4 to calculate amount of bacterials that will grow over the time.");
		input = sc.nextLine();
		switch (input) {
		case "1":
			return new ViewAccountPrompt().run();
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		default:
			System.out.println("You are so trash out, please try again!");
			break;
		}
		return null;
	}

}
