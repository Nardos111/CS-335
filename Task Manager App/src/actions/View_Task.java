package actions;

import java.util.Scanner;

public class View_Task  extends Actions{
	
	public void displayMessage() {
		System.out.println("Display selected task ");
	}
	
	public String userInput() {
		while(true) {
			System.out.println("Enter task number to view details: ");
			try (Scanner scanner = new Scanner(System.in)) {
				String userInput = scanner.nextLine();
				try {
					int number = Integer.parseInt(userInput);
				} catch(NumberFormatException nfe) {
					System.out.println("Please enter a valid input. ");
				}
				return userInput;
			}
		}
	}
	
	public void doAction(String action) {
//		Retrieve the task from task list;
	}
	
}