package actions;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import Task.Task_List;

public class View_All_Tasks  extends Actions{
	
	public void displayMessage() {
		System.out.println("Display details of all tasks ");
	}
	
	public String userInput() {
		//throw new UnsupportedOperationException("No input is required for this.");
		return null; 
	}
	
	public void doAction(String action) {
		AtomicInteger counter = new AtomicInteger(1);
		Task_List.tasks.forEach(task -> {
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
			counter.getAndIncrement(); //need to increment without returning 
		});
	}
	
}