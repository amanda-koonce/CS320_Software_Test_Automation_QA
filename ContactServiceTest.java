package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "John", "Smith",
                "1234567890", "123 Main St");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "John", "Smith",
                "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "John", "Smith",
                "1234567890", "123 Main St");

        service.addContact(contact);

        service.updateContact(
                "12345", "Jane", "Jones",
                "0987654321", "456 Main St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Main St", contact.getAddress());
    }

    @Test
    void testUpdateContactNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(
                    "12345", "Jane", "Jones",
                    "0987654321", "456 Main St");
        });
    }
} 