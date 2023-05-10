package actions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

import Task.Task;
import Task.Task_List;

public class Modify_Task extends Actions{

	public void displayMessage() {
		System.out.println("Select the task you want to modify and make changes you want. Just press enter if you want a specific field to stay the same ");
	}
	
	public String userInput() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Enter task number to view details: ");
				
				String userInput = scanner.nextLine();
				try {
					int number = Integer.parseInt(userInput);
					while (number < 1 || number > Task_List.tasks.size()) { 
						System.out.println("Please enter a number between 1 and " + Task_List.tasks.size());
						userInput = scanner.nextLine();
						number = Integer.parseInt(userInput);
						} 
					
				} catch(NumberFormatException nfe) {
					System.out.println("Please enter a valid input. ");
					userInput = scanner.nextLine();
				}
			
				return userInput;
			}
		} 
	
	
	public void doAction(String action) {
		int number = Integer.parseInt(action);
		Scanner scanner = new Scanner(System.in);
		Boolean kg = false;  
		do {
				Task task = Task_List.tasks.get(number-1);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String dueDate = task.getDueDate().format(formatter);
				
				System.out.println("Title: " + task.getTitle());
				System.out.print("New title: ");
				String title = scanner.nextLine();
				if(!title.isEmpty()) {
					task.setTitle(title);
				}
				
				System.out.println("Due date: " + dueDate);
				System.out.print("New due date(dd-mm-yyyy): ");
				String newDueDate = scanner.nextLine();
			     String pattern = "^\\d{2}-\\d{2}-\\d{4}$"; 
				if(!newDueDate.isEmpty()) {
				    Boolean matches = Pattern.matches(pattern, newDueDate); 
			         while(! matches) {
			        	 System.out.println("Please enter the correct format Due Date (dd-mm-yyyy):"); 
				         newDueDate = scanner.nextLine();
				         matches = Pattern.matches(pattern, newDueDate);
			         } 
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
		
				String newPriority = scanner.nextLine();
				if(!newPriority.isEmpty()) {
					int newpriority = Integer.parseInt(newPriority);
		            while(newpriority<1 | newpriority>3 ){
			        	System.out.println(" Please enter a number between 1 and 3"); 
			        	 newpriority = scanner.nextInt();} 
					task.setPriority(newpriority);
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
				     String NUMS = "123"; 
				   while(!NUMS.contains(status)){
					   System.out.println("Please enter 1, 2 or 3"); 
					   status = scanner.nextLine(); } 
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
				kg = true;

				
			}  while(kg==false); 
		
			
		}


		
	}

