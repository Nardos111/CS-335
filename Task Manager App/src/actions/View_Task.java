package actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Task.*;
public class View_Task  extends Actions{
	
	public void displayMessage() {
		System.out.println("Display details of a selected task ");
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
		int number = Integer.parseInt(action);
		while(true) {
			if(number < Task_List.tasks.size()-1 && number > 0) {
				Task task = Task_List.tasks.get(number-1);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String dueDate = task.getDueDate().format(formatter);
				System.out.println("Title: " + task.getTitle());
				System.out.println("Due date: " + dueDate);
				System.out.println("Description: " + task.getDescription());
				System.out.println("Priority: " + task.getPriority());
				System.out.println("Category: " + task.getCategory());
				System.out.println("Status: " + task.getStatus());
				System.out.println("");
				break;
			}
			else {
				System.out.println("Please enter a number between 1 and " + Task_List.tasks.size());
			}
		}
	}
}