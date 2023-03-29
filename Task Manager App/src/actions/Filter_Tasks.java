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
		while(true) {
			System.out.println("Which task status do you want to filter? ");
			System.out.println("1. To-do");
			System.out.println("2. In-progress");
			System.out.println("3. Completed");
			Scanner scanner = new Scanner(System.in); 
				String userInput = scanner.nextLine();
				try {
					int number = Integer.parseInt(userInput);
				} catch(NumberFormatException nfe) {
					System.out.println("Please enter a valid input. ");
				}	
				return userInput;
		}
	} 
	public void doAction(String action) {
		List<Task> filteredTasks = null;
		switch(action) {
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