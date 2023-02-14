package actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Task.Task;
import Task.Task_List;

public class Modify_Task extends Actions{

	public void displayMessage() {
		System.out.println("Select the task you want to modify and make changes you want. Just press enter if you want a specific field to stay the same ");
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
				Scanner scanner = new Scanner(System.in);
				System.out.println("Title: " + task.getTitle());
				System.out.print("New title: ");
				String title = scanner.nextLine();
				if(!title.isEmpty()) {
					task.setTitle(title);
				}
				System.out.println("Due date: " + dueDate);
				System.out.print("New due date(dd-mm-yyyy): ");
				String newDueDate = scanner.nextLine();
				if(!newDueDate.isEmpty()) {
					LocalDate newDueDate2 = LocalDate.parse(newDueDate, formatter);
					task.setDueDate(newDueDate2);
				}
				System.out.println("Description: " + task.getDescription());
				System.out.print("Updated description: ");
				String description = scanner.nextLine();
				if(!description.isEmpty()) {
					task.setDescription(description);
				}
				System.out.println("Priority: " + task.getPriority());
				System.out.print("Updated priority(1-3): ");
				String priority = scanner.nextLine();
				if(!priority.isEmpty()) {
					int newPriority = Integer.parseInt(priority);
					task.setPriority(newPriority);
				}
				System.out.println("Category: " + task.getCategory());
				System.out.print("New category: ");
				String category = scanner.nextLine();
				if(!category.isEmpty()) {
					task.setCategory(category);
				}
				System.out.println("Status: " + task.getStatus());
				System.out.print("Updated Status(1. To-do, 2. In-progress, 3. Complete): ");
				String status = scanner.nextLine();
				if(!status.isEmpty()) {
					switch(status) {
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
					task.setStatus(status);
				}
				System.out.println("Task updated successfully!");
				System.out.println("");
				scanner.close();
				return;
			}
			else {
				System.out.println("Please enter a number between 1 and " + Task_List.tasks.size());
			}
		}
	}
}

