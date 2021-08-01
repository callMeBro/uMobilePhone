package mobilephone;

import java.util.ArrayList;

/**
 *
 * @author adder
 */
public class MobilePhone {

    // write code here
    String myNumber;
    ArrayList<Contact> myContacts;

    public MobilePhone(String phoneNumber) {
        myNumber = phoneNumber;
        myContacts = new ArrayList<Contact>();          //creats new empty list
    }

//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
    /**
     * Add new contact
     *
     * @param c
     * @return
     */
    public boolean addNewContact(Contact c) {
        if (findContact(c.getName()) >= 0) {
            System.out.println("Contact already on file");
            return false;
        }
        myContacts.add(c);
        return true;

    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int exist = findContact(oldContact);
        if (exist < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        }
        myContacts.set(exist, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    /**
     * This method removes a contact
     *
     * @param c
     * @return
     */
    public boolean removeContact(Contact c) {
        int exist = findContact(c);
        if (exist > -1) {
            myContacts.remove(c);
            System.out.println(c.getName() + " was deleted.");
            return true;
        }
        System.out.println(c.getName() + " Was not found.");
        return false;
    }

    /**
     * Method that finds a contact
     *
     * @param c
     * @return
     */
    public int findContact(Contact c) {
        // return index of contact
        return this.myContacts.indexOf(c);
    }

    /**
     * This method loops through the array list to searches to see f contact
     * matches the name passed in
     *
     * @param contactName
     * @return
     */
    public int findContact(String contactName) {
        System.out.println("Looking for contact name.");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contacts = this.myContacts.get(i);       //get specific contact
            if (contacts.getName().equals(contactName)) {
                //.equals(contactName))
                return i;           //returns the index position
            }
        }
        return -1;
    }

    /**
     * Method finds the contact and returns it of found
     *
     * @param c - Contact to be passed to method
     * @return - Returns the contact if found otherwise null
     */
    public String queryContact(Contact c) {
        if (findContact(c) >= 0) {
            return c.getName();
        }
        return null;
    }

    public Contact queryContatct(String name) {
        System.out.println("        In string method");
        int position = findContact(name);
        if (position >= 0) {        //found an entry
            return this.myContacts.get(position);         //returns contact object
        }
        return null;
    }

    /**
     * Navigate through the entire contact list and get the name a phone number
     */
    public void printContacts() {
        //loop through contacts and print them
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contacts = this.myContacts.get(i);
            System.out.println("Name: " + contacts.getName() + "\nPhone Number "
                    + contacts.getPhoneNumber());
        }

    }

}
