package actions;
import Task.Task_List;

public class Run_Program {
	public static void main(String[] args) {

     	Task_List task_manager = new Task_List();
  

        task_manager.startApplication();
        task_manager.showSummary(); 
        System.out.println("  "); 
        task_manager.saveToFile("/Users/samanthamargolin/Desktop/Task-Manager-master");
        System.out.println(" "); 
        task_manager.readFile("/Users/samanthamargolin/Desktop/Task-Manager-master/Task Manager App/src/test_readfile"); 
    }

}
