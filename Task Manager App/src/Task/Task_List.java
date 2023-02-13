package Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import actions.*;

public class Task_List {

	public static Map<String, Task> tasks = new LinkedHashMap<>();
	public static boolean openApplication = true;
	
	public void startApplication() {
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
			String getInput = action.userInput();
			action.doAction(getInput);
			break;
		
		case Actions.VIEW_TASK:
			action = new Create_Task();
			action.displayMessage();
			String getInput2 = action.userInput();
			action.doAction(getInput);
			break;
			
		case Actions.VIEW_ALL_TASKS:
			action = new Create_Task();
			action.displayMessage();
			String getInput3 = action.userInput();
			action.doAction(getInput);
			break;
		case Actions.MODIFY_TASK:
			action = new Create_Task();
			action.displayMessage();
			String getInput4 = action.userInput();
			action.doAction(getInput);
			break;
		case Actions.DELETE_TASK:
			action = new Create_Task();
			action.displayMessage();
			String getInput5 = action.userInput();
			action.doAction(getInput);
			break;
		case Actions.QUIT:
			saveToFile("file_path");
			openApplication = false;
			break;
		}
	}
	
	public void displayInstruction() {
		System.out.println("Task Manager application running...");
		System.out.println("Options: ");
		System.out.println("_____________________");
		System.out.println("1. Create a new task");
		System.out.println("2. View task");
		System.out.println("3  View all tasks");
		System.out.println("4. Modify task");
		System.out.println("5. Delete task");
		System.out.println("6. Query task");
		System.out.println("7. Sort task");
		System.out.println("8. Filter task");
		System.out.println("9. Quit application");
	}
	
	public int getInput() {
		List<Integer> options = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		while (true) {
			try {
				System.out.println("What do you want to do? Select a number from the listed options: ");
				Scanner scanner = new Scanner(System.in);
				int selection = scanner.nextInt();
				if(options.contains(selection)) {
					return selection;
				}
				else {
					System.out.println("Plese enter a number between 1 - 9: ");
				}
				
			} catch(Exception err) {
				System.out.println("Please enter a valid input");
			}
		}
		
	}
	
	public void readFile(String filePath) {
		try {
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String taskLine = scanner.nextLine();
				String[] sections = taskLine.split(",");
				Task task = Task.buildTask(sections[0],sections[1],sections[2],sections[3],sections[4],sections[5],sections[6]);
				
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist");
		}
	}
	
	public void saveToFile(String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath, true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			PrintWriter pWriter = new PrintWriter(bWriter);
			List<String> t = Task_List.tasks.entrySet().stream().map(text -> text.getValue().toString()).collect(Collectors.toList());
			t.forEach((task) -> {
				pWriter.println(task);
			});
			pWriter.close();
		} catch(IOException e) {
			System.out.println("File does not exist");
		}
	}
}

	