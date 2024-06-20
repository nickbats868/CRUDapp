package org.view;

import org.model.Status;
import org.model.Writer;
import org.controller.WriterController;

import java.util.Scanner;

public class WriterView {
    private final WriterController writerController;

    public WriterView(WriterController writerController) {
        this.writerController = writerController;
    }

    private int getIntInput(Scanner scanner, String prompt) {
        int input = -1;

        while (input < 0) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
        return input;
    }

    private void pause(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Create Writer");
            System.out.println("2.Get Writer by ID");
            System.out.println("3.Get all Writers");
            System.out.println("4.Update Writer");
            System.out.println("5.Delete Writer by ID");
            System.out.println("6.Exit");

            int choice = getIntInput(scanner, "Enter your choice: ");
            int id;

            switch (choice) {
                case 1:
                    while (true) {
                        id = getIntInput(scanner, "Enter Writer ID: ");
                        if (writerController.isUniqueID(id)) {
                            break;
                        } else {
                            System.out.println("ID already exists. Please enter a unique ID.");
                        }
                    }
                    scanner.nextLine();     // consume newline
                    System.out.println("Enter First Name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter Last Name:");
                    String lastName = scanner.nextLine();
                    Writer writer = new Writer();
                    writer.setId(id);
                    writer.setFirstName(firstName);
                    writer.setLastName(lastName);
                    writer.setStatus(Status.ACTIVE);
                    writerController.createWriter(writer);
                    break;
                case 2:
                    id = getIntInput(scanner, "Enter Writer ID");
                    scanner.nextLine(); //consume newline (?? logic)
                    Writer foundWriter = writerController.getWriterById(id);
                    if (foundWriter != null) {
                        System.out.println(foundWriter.getFirstName() + " " + foundWriter.getLastName());
                    } else {
                        System.out.println("Writer not found!");
                    }
                    pause(scanner);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("All Writers:");
                    writerController.getAllWriters().forEach(System.out::println);
                    pause(scanner);
                    break;
                case 4:
                    id = getIntInput(scanner, "Enter Writer ID: ");
                    scanner.nextLine();
                    System.out.println("Enter First Name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter Last Name:");
                    lastName = scanner.nextLine();
                    writer = writerController.getWriterById(id);
                    if (writer != null) {
                        writer.setFirstName(firstName);
                        writer.setLastName(lastName);
                        writerController.updateWriter(writer);
                    } else {
                        System.out.println("Writer not found!");
                    }
                    pause(scanner);
                    break;
                case 5:
                    System.out.println("Enter Writer ID:");
                    id = scanner.nextInt();
                    System.out.println("Writer with id: " + id + " deleted.");
                    writerController.deleteWriterById(id);
                    pause(scanner);
                    break;
                case 6:
                    System.exit(0);
            }
        }


    }
}
