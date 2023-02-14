package actions;
import Task.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Create_Task extends Actions {
	
	public void displayMessage() {
		System.out.println("To add a new task, enter the task information line by line accordingly...");
	}
	
	public String userInput() {
		while(true) {
			System.out.println("Enter task: ");
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Title: ");
				String title = scanner.nextLine();
				System.out.println("Due Date(dd-mm-yyyy): ");
				String dueDate = scanner.nextLine();
				System.out.println("Description: ");
				String description = scanner.nextLine();
				System.out.println("Priority(1-3): ");
				String priority = scanner.nextLine();
				System.out.println("Category: ");
				String category = scanner.nextLine();
				System.out.println("Status(1. To-do, 2. In-progress, 3. Completed): ");
				String status = scanner.nextLine();
				if (!title.isEmpty() && "123".contains(priority)) {
					return title+","+dueDate+","+description+","+priority+","+category+","+status;
				}
				else {
					System.out.println("Please enter a valid input.");
				}
			}
		}
		
	}
	
	public void doAction(String action) {
		String[] inputs = action.split(",");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dueDate = LocalDate.parse(inputs[1], formatter);
		int priority = Integer.parseInt(inputs[3]);
		String status;
		switch(inputs[5]) {
		case "1":
			status = "To-do";
			break;
		case "2":
			status = "In-progress";
			break;
		case "3":
			status = "Completed";
			break;
		default: 
			status = "Invalid status";
			break;
		}
		Task task = Task.buildTask(inputs[0], dueDate, inputs[2], priority, inputs[4], status);
		Task_List.tasks.add(task);
		System.out.println("New task has been added!");
		
	}	

}
