import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean completed;

    Task(String name) {
        this.name = name;
        this.completed = false;
    }

    void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return name + " - " + (completed ? "Completed" : "Pending");
    }
}

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Display the menu
    public static void displayMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. View Tasks");
        System.out.println("2. Add Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. Exit");
    }

    // View all tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Add a new task
    public static void addTask() {
        System.out.print("Enter the task description: ");
        scanner.nextLine(); // To clear the buffer
        String taskName = scanner.nextLine();
        tasks.add(new Task(taskName));
        System.out.println("Task '" + taskName + "' added!");
    }

    // Delete a task
    public static void deleteTask() {
        viewTasks();
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Mark a task as completed
    public static void markTaskCompleted() {
        viewTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Main function to run the program
    public static void main(String[] args) {
        int choice;

        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewTasks();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    markTaskCompleted();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
