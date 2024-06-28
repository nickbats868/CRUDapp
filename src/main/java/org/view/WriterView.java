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
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
        return input;
    }

    private String getStringInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("[a-zA-Z]+")) {
                input = capitalize(input);
                break;
            } else {
                System.out.println("Invalid input. Enter letters only.");
            }
        }
        return input;
    }

    private String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
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
            String firstName;
            String lastName;
            Writer writer;

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
                    firstName = getStringInput(scanner,"Enter First Name:");
                    lastName = getStringInput(scanner,"Enter Last Name:");
                    writer = new Writer();
                    writer.setId(id);
                    writer.setFirstName(firstName);
                    writer.setLastName(lastName);
                    writer.setStatus(Status.ACTIVE);
                    writerController.createWriter(writer);
                    break;
                case 2:
                    id = getIntInput(scanner, "Enter Writer ID");
                    Writer foundWriter = writerController.getWriterById(id);
                    if (foundWriter != null) {
                        System.out.println(foundWriter.getFirstName() + " " + foundWriter.getLastName());
                    } else {
                        System.out.println("Writer not found!");
                    }
                    pause(scanner);
                    break;
                case 3:
                    System.out.println("All Writers:");
                    writerController.getAllWriters().forEach(System.out::println);
                    if (writerController.getAllWriters().isEmpty()) {
                        System.out.println("There is not a single writer on the list");
                    }
                    pause(scanner);
                    break;
                case 4:
                    id = getIntInput(scanner, "Enter Writer ID: ");
                    System.out.println("Enter First Name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter Last Name:");
                    lastName = scanner.nextLine();
                    writer = writerController.getWriterById(id);
                    if (writer != null) {
                        writer.setFirstName(firstName);
                        writer.setLastName(lastName);
                        writerController.updateWriter(writer);
                        System.out.println("Changed to: " + writer.getFirstName() + " " + writer.getLastName());
                    }
                    pause(scanner);
                    break;
                case 5:
                    while (true) {
                        System.out.println("Enter 0 to return to the main menu.");
                        id = getIntInput(scanner, "Enter Writer ID to delete: ");
                        if (id == 0) {
                            break;
                        }
                        boolean deleted = writerController.writerRepository.deleteById(id);
                        if (deleted) {
                            System.out.println("Writer with ID: " + id + " was deleted.");
                            pause(scanner);
                            break;
                        } else {
                            System.out.println("Writer with ID: " + id + " not found. Enter a valid ID.");
                            pause(scanner);
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("There is no such function. Please select a number from the list. ");
                    pause(scanner);
            }

        }


    }
}
