package com.ulanzhasssanov.CrudAppWithHibernate.view;

import com.ulanzhasssanov.CrudAppWithHibernate.controller.WriterController;
import com.ulanzhasssanov.CrudAppWithHibernate.enums.Status;
import com.ulanzhasssanov.CrudAppWithHibernate.model.Writer;

import java.util.Scanner;

public class WriterView {
    WriterController writerController = new WriterController();
    private final Scanner scanner = new Scanner(System.in);

    public void writerOperations(){

        while (true) {
            System.out.println("1. Create Writer");
            System.out.println("2. Display All Writers");
            System.out.println("3. Display Writer by ID");
            System.out.println("4. Update Writer");
            System.out.println("5. Delete Writer");
            System.out.println("0. Exit from Writer operations");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter firstName: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter lastName: ");
                    String lastName = scanner.nextLine();


                    Writer writer = new Writer(firstName, lastName, Status.ACTIVE);
                    System.out.println(writerController.saveWriter(writer));
                    System.out.println("Writer saved to db");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("All writers:");
                    System.out.println(writerController.getAllWriters());
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter id to find: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Writer with id " + id + ":");
                    System.out.println(writerController.getWriterById(id));
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter id to update: ");
                    int writerUpdateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(writerController.getWriterById(writerUpdateId));

                    System.out.print("Enter new firstName: ");
                    String writerUpdateFirstName = scanner.nextLine();
                    System.out.print("Enter new lastName: ");
                    String writerUpdateLastName = scanner.nextLine();

                    Writer writerUpdate = writerController.getWriterById(writerUpdateId);

                    writerUpdate.setFirstName(writerUpdateFirstName);
                    writerUpdate.setLastName(writerUpdateLastName);

                    System.out.println("Updated writer " + writerUpdateId + ":");
                    System.out.println(writerController.updateWriter(writerUpdate));
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter id to delete: ");
                    int writerDeleteId = scanner.nextInt();
                    scanner.nextLine();

                    writerController.deleteWriter(writerDeleteId);
                    System.out.println("Writer deleted");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Exiting from WriterView");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
    }


}
