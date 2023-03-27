package actions;
import Task.Task_List;

public class Run_Program {
	public static void main(String[] args) {

     	Task_List task_manager = new Task_List();
        task_manager.startApplication();
        System.out.println("  "); 
        task_manager.saveToFile("./Task_file/task_list");
        System.out.println(" "); 
    }

}
