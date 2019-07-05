package com.mybank.prompts;

import java.util.Scanner;

import com.mybank.daos.Dao;

public class InterestCalculationPrompt implements Prompt {

	private Scanner sc = new Scanner(System.in);
	private Dao d = Dao.current;

	@Override
	public Prompt run() {
		double result;
		String input;
		String number;
		double n = 0;
		String rate;
		double r = 0;
		String month;
		int m = 0;
		System.out.println("Wellcome to the calculation of the amount growing of bacterials over time!");
		System.out.println("During the input for calculation, if you would like to exit, please enter q at any time!");
		System.out.println("Please input the initial number of bacterials already exist:");
		number = sc.nextLine();
		do {
			try {

				n = Double.valueOf(number);
				if (n <= 0) {
					System.out.println("There is always at least a bacterial in your trash bin, try again:");
					number = sc.nextLine();
				}
			} catch (NumberFormatException e) {
				if(number.equalsIgnoreCase("q")) {
					return new HomePrompt();
				}else {
				System.out.println("invalid number, try agian:");
				number = sc.nextLine();
				}
			}
		} while (n == 0);
		System.out.println("Please input the rate that bacterial will grow");
		rate = sc.nextLine();
		do {
			try {

				r = Double.valueOf(rate);
				if (r <= 0) {
					System.out.println("Bacterials will grow over time, give me a valid rate, try again:");
					rate = sc.nextLine();
				}
			} catch (NumberFormatException e) {
				if(rate.equalsIgnoreCase("q")) {
					return new HomePrompt();
				}else {
				System.out.println("invalid number, try agian:");
				rate = sc.nextLine();
				}
			}
		} while (r == 0);
		System.out.println("Please input the month that you intend to leave the trash bin alone");
		month = sc.nextLine();
		do {
			try {

				m = Integer.valueOf(month);
				if (m <= 0) {
					System.out.println("Month can not be zero, please put at least 1, try again:");
					month = sc.nextLine();
				}
			} catch (NumberFormatException e) {
				if(month.equalsIgnoreCase("q")) {
					return new HomePrompt();
				}else {
				System.out.println("invalid number, try agian:");
				month = sc.nextLine();
				}
			}
		} while (m == 0);
		System.out.println("You have input Bacterials: " + n + ", Grow Rate: " + r + "%, Month: " + m);
		System.out.println("Are these correct? (y/other keys for no)");
		input = sc.nextLine();
		if(input.equalsIgnoreCase("y")) {
			result = d.calculateInterest(n, r, m);
			System.out.println("After " + m +" month(s), your bacterial will grow to : " + result + " bacterials.");
			System.out.println("Do you want to make another calculation? (y/other keys for no)");
			input = sc.nextLine();
			if (input.equalsIgnoreCase("y")) {
				return new InterestCalculationPrompt();
				
			}else {
				return new HomePrompt();
			}
		}else {
			return new InterestCalculationPrompt();
		}
	}

}
