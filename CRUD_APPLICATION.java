import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

public class CRUD_APPLICATION {
    private List<Task> tasks;
    private Scanner scanner;

    public CRUD_APPLICATION() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        Task newTask = new Task(title);
        tasks.add(newTask);
        System.out.println("Task created: " + newTask);
    }

    public void readTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    public void updateTask() {
        System.out.print("Enter task index to update: ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask() {
        System.out.print("Enter task index to delete: ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (index >= 0 && index < tasks.size()) {
            Task deletedTask = tasks.remove(index);
            System.out.println("Task deleted: " + deletedTask);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nCRUD Application Menu:");
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    readTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    public static void main(String[] args) {
        CRUD_APPLICATION app = new CRUD_APPLICATION();
        app.run();
    }
}
