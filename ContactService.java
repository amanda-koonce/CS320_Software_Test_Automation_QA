package contactservice;

import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void addContact(Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        Contact contactToDelete = null;

        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contactToDelete = contact;
                break;
            }
        }

        if (contactToDelete == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactToDelete);
    }

    public void updateContact(String contactId, String firstName,
            String lastName, String phone, String address) {

        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setPhone(phone);
                contact.setAddress(address);
                return;
            }
        }

        throw new IllegalArgumentException("Contact ID not found");
    }
}