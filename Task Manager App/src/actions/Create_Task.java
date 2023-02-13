package actions;
import Task.Task;

import java.util.Scanner;


public class Create_Task extends Actions {
	
	public void displayMessage() {
		System.out.println("To add a new task make sure you follow the following format...");
	}
	
	public String userInput() {
		while(true) {
			System.out.println("Enter task: ");
			try (Scanner scanner = new Scanner(System.in)) {
				String userInput = scanner.nextLine();
				
				String[] inputs = userInput.split(",");
				if (inputs.length == 6) {
					return userInput;
				}
				else {
					System.out.println("Please enter a valid input. ");
				}
			}
		}
		
	}
	
	public void doAction(String action) {
		String[] inputs = action.split(",");
		Task task = Task.buildTask(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);
//		Created task needs to be added to a list here
		System.out.println("New task has been added!");
		
	}	

}
