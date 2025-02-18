package dev.duyhvt.section_10.MobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(contact.getName())) {
                return false;
            }
        }
        myContacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(contact.getName())) {
                myContacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(oldContact.getName())) {
                myContacts.set(i, newContact);
                return true;
            }
        }
        return false;
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    public Contact queryContact(String name) {
        return (findContact(name) >= 0) ? myContacts.get(findContact(name)) : null;
    }

    public void printContact() {
        System.out.println("Contact List: ");
        for (int i = 0; i < myContacts.size(); i++) {
            String name = myContacts.get(i).getName();
            String phone = myContacts.get(i).getPhoneNumber();
            System.out.println((i+1) + ". " + name + " -> " + phone);
        }
    }
}