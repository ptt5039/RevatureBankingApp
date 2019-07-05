package com.mybank.app;

import com.mybank.prompts.HomePrompt;
import com.mybank.prompts.Prompt;

public class ApplicationDriver {
	public static void main(String[] args) {
		Prompt p = new HomePrompt();
		while(true) {
			p = p.run();
		}
	}
}
