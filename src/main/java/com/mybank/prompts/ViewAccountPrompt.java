package com.mybank.prompts;

import java.util.List;
import java.util.Scanner;

import com.mybank.daos.BankDaoInMemory;
import com.mybank.daos.Dao;
import com.mybank.models.Bank;

public class ViewAccountPrompt implements Prompt {
	
	Scanner sc = new Scanner(System.in);
	Dao d = new BankDaoInMemory();
	List<Bank> banks;
	
	@Override
	public Prompt run() {
		String input;
		banks = d.viewAccount();
		int counter = 0;
		
		for (Bank bank: banks) {
			counter++;
			System.out.println((counter) + ". Trash bin type: " + bank.getType() + ", number of trash piece: "
					+ bank.getBalance());
		}
		
		System.out.println("\nEnter trash bin's number you want to use or q to return to main menu.");
		
		input = sc.nextLine();
		
		
		
		
		try {
			int convert = Integer.valueOf(input);
			if(convert <= banks.size()) {
				if (convert >0) {
					d.setCurrentChoice(convert-1);
					return new WithdrawOrDepositPrompt().run();
				}else if (convert <= 0){
					System.out.println("You made a invalid choice, return to the main menu!");
					return new HomePrompt();
				}
			}else {
				System.out.println("You made a invalid choice, return to the main menu!");
				return new HomePrompt();
			}
		} catch (NumberFormatException e) {
			{
				if(input.equalsIgnoreCase("q")) {
					return new HomePrompt();
				}else {
					System.out.println("You made a invalid choice, please try again!");
					return new ViewAccountPrompt();
				}
			}
		}
		
		return null;
		
	}

}
