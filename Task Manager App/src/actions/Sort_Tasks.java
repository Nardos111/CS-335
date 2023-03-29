package actions;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import Task.Task_List;

public class Sort_Tasks  extends Actions{
	
	public void displayMessage() {
		System.out.println("Sortings tasks...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String userInput() {
		return null; 
	}
	
	public void doAction(String action) {
		Collections.sort(Task_List.tasks);
	}
	
}