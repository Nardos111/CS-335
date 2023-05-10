package Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import actions.*;

public class Task_List {

	public static ArrayList<Task> tasks= new ArrayList<Task>();
	public static boolean openApplication = true;
	
	public void startApplication() {
		readFile("./Task_file/task_list");
		while(Task_List.openApplication) {
			displayInstruction();
			int selectAction = getInput();
			doAction(selectAction);
		}
	}
	

	
	public void doAction(int selectAction) {
		Actions action;
		
		switch(selectAction) {
		case Actions.CREATE_NEW_TASK:
			action = new Create_Task();
			action.displayMessage();
			String userInput = action.userInput();
			action.doAction(userInput);
			break;
		
		case Actions.VIEW_TASK:
			action = new View_Task();
			action.displayMessage();
			showSummary();
			String userInput2 = action.userInput();
			action.doAction(userInput2);
			break;
			
		case Actions.VIEW_ALL_TASKS:
			action = new View_All_Tasks();
			action.displayMessage();
			String userInput3 = action.userInput();
			action.doAction(userInput3);
			break;
			
		case Actions.MODIFY_TASK: 
			action = new Modify_Task();
			action.displayMessage();
			showSummary();
			String userInput4 = action.userInput();
			action.doAction(userInput4);
			break;
			
		case Actions.DELETE_TASK: 
			action = new Delete_Task();
			action.displayMessage();
			showSummary();
			String userInput5 = action.userInput();
			action.doAction(userInput5);
			break;
			
		case Actions.SORT_TASKS:
			action = new Sort_Tasks();
			action.displayMessage();
			String userInput6 = action.userInput();
			action.doAction(userInput6);
			showSummary();
			break;
			
		case Actions.FILTER_TASKS:
			action = new Filter_Tasks();
			action.displayMessage();
			String userInput7 = action.userInput();
			action.doAction(userInput7);
			break;
		case Actions.DOWNLOAD:
			downloadtemplate("Template_download");
			System.out.println("Template Downloaded...");
			break;
		case Actions.QUIT:
			saveToFile("file_path");
			openApplication = false;
			System.out.println("Closing application...");
			break;
		}
	}
	
	public void displayInstruction() {
		System.out.println("Task Manager application running...");
		System.out.println("");
		System.out.println("Options: ");
		System.out.println("_____________________");
		System.out.println("1. Create a new task");
		System.out.println("2. View task");
		System.out.println("3  View all tasks");
		System.out.println("4. Modify task");
		System.out.println("5. Delete task");
		System.out.println("6. Sort task"); // to do alphabetic 
		System.out.println("7. Filter task"); // to do by numeric
		System.out.println("8. Download Template"); // to do by numeric
		System.out.println("9. Quit application");
	}

	
	public int getInput() {
	    List<Integer> options = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	    Scanner scanner = new Scanner(System.in); 
			System.out.println("What do you want to do? Select a number from the listed options: ");
			boolean kg = false;
			int selection1;
			do {
			    selection1 = scanner.nextInt();
			    if (options.contains(selection1)) {
			        kg = true;
			    } else {
			        System.out.println("Invalid input. Please select a number from the listed options: ");
			    }
			    
			} while(!kg);
   
			return selection1;
		}
	



	
	public void readFile(String filePath) {
		try {
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String taskLine = scanner.nextLine();
				String[] sections = taskLine.split(",");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dueDate = LocalDate.parse(sections[1], formatter);
				int priority = Integer.parseInt(sections[3]);
				Task task = Task.buildTask(sections[0],dueDate,sections[2],priority,sections[4],sections[5]);
				tasks.add(task);
				
			}
			scanner.close();
		}
		catch(FileNotFoundException err) {
			System.out.println("File does not exist");
		}
	}
	public void downloadtemplate(String filePath) {
		String heading = "Template for Syllabus"; 
		String  elements = "Title Due Date (dd-mm-yyyy) Description Priority (1-3) Category Status (1. To-do, 2. In-progress, 3. Completed)"; 
		
		try {
			File template = new File(filePath);
			FileWriter fw = new FileWriter(template);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(heading);
			pw.write(elements);
			
			pw.flush();
			 pw.close();}
		catch(IOException e){
			System.out.println("File does not save");
		}
		}
	
	public void readSyllabus(String filePath) {
		try {
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String taskLine = scanner.nextLine(); 
				String[] sections = taskLine.split(",");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dueDate = LocalDate.parse(sections[1], formatter);
				int priority = Integer.parseInt(sections[3]);
				Task task = Task.buildTask(sections[0],dueDate,sections[2],priority,sections[4],sections[5]);
				tasks.add(task);
				
			}
			scanner.close();
		}
		catch(FileNotFoundException err) {
			System.out.println("File does not exist");
		}
	}
	
	public void saveToFile(String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath, false);
			BufferedWriter bWriter = new BufferedWriter(writer);
			PrintWriter pWriter = new PrintWriter(bWriter);
			tasks.forEach((task) -> {
				pWriter.println(task);
			});
			pWriter.flush();
			pWriter.close();
		} catch(IOException e) {
			System.out.println("File does not exist");
		}
	}
	
	public void showSummary() {
		AtomicInteger counter = new AtomicInteger(1);
		tasks.forEach(task -> {
			System.out.print(counter.get() + ". " + task.getTitle() + "\n");
			counter.getAndIncrement(); 
		});	
	}
}

	