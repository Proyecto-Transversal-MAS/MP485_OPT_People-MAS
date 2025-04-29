package model.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javax.swing.ImageIcon;
import java.util.Date;

class PersonTest {

    private Person person;
    private Person personWithFullData;
    private final String nif = "12345678X";
    private final String name = "John Doe";
    private final String email = "johndoe@example.com";
    private final Date dateOfBirth = new Date();
    private final ImageIcon photo = new ImageIcon();

    @Test
    void testConstructorNifOnly() {
        assertEquals(nif, person.getNif());
        assertNull(person.getName());
        assertNull(person.getDateOfBirth());
        assertNull(person.getPhoto());
    }

    @Test
    void testConstructorNameAndNif() {
        Person personWithNameNifAndEmail = new Person(name, nif, email);
        assertEquals(name, personWithNameNifAndEmail.getName());
        assertEquals(nif, personWithNameNifAndEmail.getNif());
        assertEquals(nif, personWithNameNifAndEmail.getEmail());
    }

    @Test
    void testConstructorFullData() {
        assertEquals(name, personWithFullData.getName());
        assertEquals(nif, personWithFullData.getNif());
        assertEquals(email, personWithFullData.getEmail());
        assertEquals(dateOfBirth, personWithFullData.getDateOfBirth());
        assertEquals(photo, personWithFullData.getPhoto());
    }

    @Test
    void testGettersAndSetters() {
        person.setName("Jane Doe");
        assertEquals("Jane Doe", person.getName());

        Date newDateOfBirth = new Date(0);
        person.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, person.getDateOfBirth());

        ImageIcon newPhoto = new ImageIcon("path/to/photo.jpg");
        person.setPhoto(newPhoto);
        assertEquals(newPhoto, person.getPhoto());

        byte[] photoBytes = new byte[]{1, 2, 3};
        person.setPhotoOnlyJPA(photoBytes);
        assertArrayEquals(photoBytes, person.getPhotoOnlyJPA());
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(person.equals(person));
    }

    @Test
    void testEqualsDifferentObject() {
        Person anotherPerson = new Person(nif);
        assertTrue(person.equals(anotherPerson));

        Person differentPerson = new Person("98765432Z");
        assertFalse(person.equals(differentPerson));
    }

    @Test
    void testHashCode() {
        Person anotherPerson = new Person(nif);
        assertEquals(person.hashCode(), anotherPerson.hashCode());

        Person differentPerson = new Person("98765432Z");
        assertNotEquals(person.hashCode(), differentPerson.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Person {Name = " + name + ", NIF = " + nif
                + ", DateOfBirth = " + dateOfBirth + ", Photo = true}";
        assertEquals(expected, personWithFullData.toString());
    }
}
