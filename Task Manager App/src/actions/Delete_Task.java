package actions;

import java.util.Scanner;

import Task.Task_List;

public class Delete_Task  extends Actions {

		public void displayMessage() {
			System.out.println("What task do you want to delete");
		}
		
		public String userInput() {
			while(true) {
				System.out.println("Enter task number you want to delete: ");
				Scanner scanner = new Scanner(System.in); 
					String userInput = scanner.nextLine();
					int number = Integer.parseInt(userInput);
				
						while(number <= 0 | number > Task_List.tasks.size()) { 
							System.out.println("Please enter a number between 1 and " + Task_List.tasks.size());
							userInput = scanner.nextLine();
							number = Integer.parseInt(userInput);
							}
					
					return userInput;
				}
			}  
	


public void doAction(String action) {
	int number = Integer.parseInt(action);
			Task_List.tasks.remove(number-1);
			System.out.println("Task was successfully removed");
			//return; 
		}
	


	}



