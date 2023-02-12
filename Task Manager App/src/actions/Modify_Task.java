package actions;

import java.util.Scanner;

public class Modify_Task extends Actions{

	public void displayMessage() {
		System.out.println("Select the task you want to modify and then make the changes using the following format...");
	}
	
	public String userInput() {
		while(true) {
			System.out.println("Which task do you want to modify - enter id: ");
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
		String[] inputs = action.split(",");
		//modify task from task list
		System.out.println("Task has been modified!");
	}
}
