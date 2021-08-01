package mobilephone;

import java.util.Scanner;

/**
 *
 * @author adder
 */
public class Main {

    //import sc and craete new mobile phone class with phone number
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mp = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {

        boolean quit = false;

        startPhone();

        printActions();
        while (!quit) {
            System.out.print("\nEnter action: (6 to show available actions) ");
            int action = sc.nextInt();
            sc.nextLine();          //clear input stream

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mp.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }
        }

    }

    private static void addNewContact() {
        System.out.print("Enter new contact name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        //create a new contact whithout having an instance or object
        Contact newContact = Contact.createContact(name, phone);
        if (mp.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.print("Enter existing contact name: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mp.queryContatct(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new contact phone number");
        String newNumber = sc.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);

        if (mp.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating contact.");
        }
    }

    private static void removeContact() {
        System.out.print("Enter existing contact name: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mp.queryContatct(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (mp.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact ");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mp.queryContatct(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is "
                + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting Phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shutdown\n"
                + "1 - to print contacts\n"
                + "2 - to add a new contact\n"
                + "3 - to update existing an existing contact\n"
                + "4 - to remove an existing contact\n"
                + "5 - query if an existing contact exists\n"
                + "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

//    private static void printContacts(){
//        mp.printContacts();
//    }
}
