package jp.itacademy.samples.web.mvc.cl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ContactList {

    private List<Contact> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public Contact remove(String name) {
        for (Iterator<Contact> itr = contacts.iterator(); itr.hasNext();) {
            Contact c = itr.next();
            if (c.getName().startsWith(name)) {
                itr.remove();
                return c;
            }
        }
        return null;
    }

    public List<Contact> search(String keyword) {
        List<Contact> matches = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().indexOf(keyword) >= 0) {
                matches.add(c);
            }
        }
        return matches;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public int getSize() {
        return contacts.size();
    }

    public void save(String filePath) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(filePath)) {
            for (Contact c : contacts) {
                out
                    .println(c.getName()
                        + " "
                        + c.getTel()
                        + " "
                        + c.getEmail());
            }
        }
    }

    public void restore(String filePath) throws FileNotFoundException {
        this.contacts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.add(new Contact(line.split(" ")));
            }
        }
    }

}
