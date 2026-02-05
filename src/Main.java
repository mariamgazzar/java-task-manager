import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // A simple Task model (kept inside the same file for simplicity)
    static class Task {
        String text;
        boolean done;

        Task(String text, boolean done) {
            this.text = text;
            this.done = done;
        }

        @Override
        public String toString() {
            return (done ? "[x] " : "[ ] ") + text;
        }
    }

    static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = loadTasks();

        System.out.println("=== Task Manager ===");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Add task");
            System.out.println("2) List tasks");
            System.out.println("3) Mark task as done");
            System.out.println("4) Exit");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter task: ");
                String text = scanner.nextLine().trim();
                if (text.isEmpty()) {
                    System.out.println("Task cannot be empty.");
                    continue;
                }
                tasks.add(new Task(text, false));
                saveTasks(tasks);
                System.out.println("Added: " + text);

            } else if (choice.equals("2")) {
                printTasks(tasks);

            } else if (choice.equals("3")) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to mark as done.");
                    continue;
                }

                printTasks(tasks);
                System.out.print("Enter task number to mark as done: ");
                String input = scanner.nextLine().trim();

                int index;
                try {
                    index = Integer.parseInt(input) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                if (index < 0 || index >= tasks.size()) {
                    System.out.println("Invalid task number.");
                    continue;
                }

                tasks.get(index).done = true;
                saveTasks(tasks);
                System.out.println("Marked as done: " + tasks.get(index).text);

            } else if (choice.equals("4")) {
                System.out.println("Bye!");
                break;

            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }

    static void printTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        System.out.println("\nYour tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ") " + tasks.get(i));
        }
    }

    // Save tasks in a super simple file format:
    // each line: done|task text
    // example: 0|Buy milk
    //          1|Pay rent
    static void saveTasks(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                String doneFlag = t.done ? "1" : "0";
                writer.write(doneFlag + "|" + t.text);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return tasks; // no file yet = no tasks yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split into two parts only (in case task text contains "|")
                String[] parts = line.split("\\|", 2);
                if (parts.length != 2) continue;

                boolean done = parts[0].equals("1");
                String text = parts[1];
                tasks.add(new Task(text, done));
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }
}
