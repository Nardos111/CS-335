package actions;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import Task.Task;
import Task.Task_List;

public class Filter_Tasks  extends Actions{
	
	public void displayMessage() {
		System.out.println("Filter tasks");
	}
	
	public String userInput() {
		while(true ) {
			System.out.println("What do you want to use to filter your tasks?");
			System.out.println("1. Priority");
			System.out.println("2. Category");
			System.out.println("3. Status");
			Scanner scanner = new Scanner(System.in);
			String userChoice = scanner.nextLine();
			String NUMS = "123"; 
			   while(!NUMS.contains(userChoice)){
				   System.out.println("Please enter 1, 2 or 3"); 
				   userChoice = scanner.nextLine(); } 

			
			return userChoice;	
		}
	}
	
	
	public void doAction(String action) {
		List<Task> filteredTasks = null;
		Scanner scanner = new Scanner(System.in);
		String NUMS = "123"; 
		switch(action) {
		case "1":
			while(true) {
			System.out.println("Which priority do you want to select?");
			System.out.println("1 ");
			System.out.println("2 ");
			System.out.println("3 ");
			String userInput = scanner.nextLine();
		
			   while(!NUMS.contains(userInput)){
				   System.out.println("Please enter 1, 2 or 3"); 
				   userInput = scanner.nextLine(); } 
			switch(userInput) {
			case "1":
				filteredTasks = Task_List.tasks.stream().filter(task -> task.getPriority()==1).collect(Collectors.toList());
				break;
			case "2":
				filteredTasks = Task_List.tasks.stream().filter(task -> task.getPriority()==2).collect(Collectors.toList());
				break;
			case "3":
				filteredTasks = Task_List.tasks.stream().filter(task -> task.getPriority()==3).collect(Collectors.toList());
				break;
			}
			break; } 
			
		case "2":
			while(true) {
			System.out.println("What category do you want to use to filter your tasks? ");
			String userInput2 = scanner.nextLine();
			filteredTasks = Task_List.tasks.stream().filter(task -> task.getCategory().contains(userInput2)).collect(Collectors.toList());
			break; } 
		case "3":
			while(true) {
				System.out.println("Which task status do you want to filter? ");
				System.out.println("1. To-do");
				System.out.println("2. In-progress");
				System.out.println("3. Completed");
				String userInput3 = scanner.nextLine();
			
				   while(!NUMS.contains(userInput3)){
					   System.out.println("Please enter 1, 2 or 3"); 
					   userInput3 = scanner.nextLine(); } 
				   
				switch(userInput3) {
				case "1":
					filteredTasks = Task_List.tasks.stream().filter(task -> task.getStatus().contains("To-do")).collect(Collectors.toList());
					break;
				case "2":
					filteredTasks = Task_List.tasks.stream().filter(task -> task.getStatus().contains("In-progress")).collect(Collectors.toList());
					break;
				case "3":
					filteredTasks = Task_List.tasks.stream().filter(task -> task.getStatus().contains("Completed")).collect(Collectors.toList());
					break;
				}
				break;
			}
		}
		if(filteredTasks.size()==0) {
			System.out.print("There is no task with that specification");
			System.out.println();
		}
		else {	
			Iterator<Task> it = filteredTasks.iterator();
			AtomicInteger counter = new AtomicInteger(1);
			while(it.hasNext()){
				Task task = it.next();
		    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String dueDate = task.getDueDate().format(formatter);
				System.out.println("Task "+counter.get());
				System.out.println("Title: " + task.getTitle());
				System.out.println("Due date: " + dueDate);
				System.out.println("Description: " + task.getDescription());
				System.out.println("Priority: " + task.getPriority());
				System.out.println("Category: " + task.getCategory());
				System.out.println("Status: " + task.getStatus());
				System.out.println("");
				counter.getAndIncrement();
			}
	    }
	}
}