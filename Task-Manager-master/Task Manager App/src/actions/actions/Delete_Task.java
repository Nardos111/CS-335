package actions;

import java.util.Scanner;

import Task.Task_List;

public class Delete_Task  extends Actions {

		public void displayMessage() {
			System.out.println("What task do you want to delete");
		}
		
		public String userInput() {
			while(true) {
				System.out.println("Enter task number to view details: ");
				Scanner scanner = new Scanner(System.in); 
					String userInput = scanner.nextLine();
					
					try {
						int number = Integer.parseInt(userInput);
					} catch(NumberFormatException e ) {
						System.out.println("Please enter a valid input. ");
					}
				
					return userInput;
				}
			}  
	


public void doAction(String action) {
	int number = Integer.parseInt(action);
	
		if(number < Task_List.tasks.size()-1 && number > 0) {
			Task_List.tasks.remove(number-1);
			//return; 
		}
		else {
			System.out.println("Please enter a number between 1 and " + Task_List.tasks.size());
		}
	System.out.println("Task was successfully removed");

	}
}


