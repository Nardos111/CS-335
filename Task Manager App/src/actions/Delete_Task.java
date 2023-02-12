package actions;

import java.util.Scanner;

public class Delete_Task  extends Actions {

		public void displayMessage() {
			System.out.println("What task do you want to delete");
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
//			remove task from list
			System.out.println("Task was successfully removed");
		}
	
}
