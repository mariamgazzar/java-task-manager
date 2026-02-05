import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.println("=== Task Manager ===");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Add task");
            System.out.println("2) List tasks");
            System.out.println("3) Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter task: ");
                String task = scanner.nextLine();
                tasks.add(task);
                System.out.println("Added: " + task);

            } else if (choice.equals("2")) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks yet.");
                } else {
                    System.out.println("\nYour tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ") " + tasks.get(i));
                    }
                }

            } else if (choice.equals("3")) {
                System.out.println("Bye!");
                break;

            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}
