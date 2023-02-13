package Task;

import java.time.LocalDate;

public class Task {
	private String title;
	private LocalDate dueDate;
	private String description;
	private int priority;
	private String category;
	private String status;

	public String getTitle() {
		return title;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return title + ", " + dueDate + ", " + description + ", " + priority + ", " + category + ", " + status;
	}
	
	public static Task buildTask(String title, LocalDate dueDate, String description, int priority, String category, String status) {
		Task task = new Task();
		task.setTitle(title);
		task.setDueDate(dueDate);
		task.setDescription(description);
		task.setPriority(priority);
		task.setCategory(category);
		task.setStatus(status);
		return task;
	}
	
}




