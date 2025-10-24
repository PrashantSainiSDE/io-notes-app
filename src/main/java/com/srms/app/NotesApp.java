package com.srms.app;

import java.io.*;
import java.util.Scanner;

public class NotesApp
{
    private static final String FILE_NAME = "notes.txt";

    private static void addNote(Scanner sc) {
        System.out.println("Enter your note (press Enter when done):");
        System.out.print("> ");
        String note = sc.nextLine();
        while (note.isBlank()) {
            System.out.println("Error: Note cannot be blank. Try again!");
            System.out.print("> ");
            note = sc.nextLine();
        }

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Success: Note added successfully!");
        } catch (IOException e) {
            System.out.println("Error: Writing note:: " + e.getMessage());
        }
    }

    private static void viewNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nYour Notes:");
            System.out.println("--------------------------------");
            boolean empty = true;

            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                empty = false;
            }

            if (empty) {
                System.out.println("(No notes found)");
            }

            System.out.println("--------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("Error: No notes found - file not created yet!");
        } catch (IOException e) {
            System.out.println("Error: Reading file: " + e.getMessage());
        }
    }

    private static void clearNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("");
            System.out.println("Success: All notes cleared successfully!");
        } catch (IOException e) {
            System.out.println("Error: Clearing notes: " + e.getMessage());
        }
    }

    // Method to get a valid menu choice from input
    public static int getMenuChoice(Scanner sc) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add a new note");
                System.out.println("2. View all notes");
                System.out.println("3. Clear all notes");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                String input = sc.nextLine().trim();

                try {
                    int choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 4) {
                        throw new IllegalArgumentException("Error: Choice must be between 1 and 4.");
                    }
                    return choice;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input! Please enter a number between 1 and 4.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n----------------------- Personal Notes App --------------------------");

        while (true) {
            int choice = getMenuChoice(sc);

            if (choice == 4) {
                System.out.println("\nShutting down! Thank you for using this app!");
                sc.close();
                break;
            }

            switch (choice) {
                case 1 -> addNote(sc);
                case 2 -> viewNotes();
                case 3 -> clearNotes();
                default -> System.out.println("Invalid choice. Try again!");
            }

            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }
    }
}
