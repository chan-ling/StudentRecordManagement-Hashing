import java.util.HashMap;
import java.util.Scanner;

public class StudentRecordManager {

    private static HashMap<String, String> studentRecords = new HashMap<>();

    // Simple string hashing function (for demonstration only).  Do not use in production systems!
    private static int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return Math.abs(hash) % 10; // Modulo operation to keep hash within table size.  Adjust as needed.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student Record");
            System.out.println("2. Search Student Record");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        //Use a better hash function in production
        int index = hash(studentID);

        studentRecords.put(studentID, studentName);
        System.out.println("Student record added successfully.");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student ID to search: ");
        String studentID = scanner.nextLine();

        if (studentRecords.containsKey(studentID)) {
            System.out.println("Student Name: " + studentRecords.get(studentID));
        } else {
            System.out.println("Student record not found.");
        }
    }
}
