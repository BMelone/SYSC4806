package com.bensoft.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressBookTest {

    @Test
    public void testSize() {
        AddressBook ab = new AddressBook();
        assertEquals(0, ab.size());
        ab.addBuddy(new BuddyInfo());
        assertEquals(1, ab.size());
        ab.addBuddy(new BuddyInfo());
        ab.addBuddy(new BuddyInfo());
        assertEquals(3, ab.size());
    }

    @Test
    public void testClear() {
        AddressBook ab = new AddressBook();
        ab.addBuddy(new BuddyInfo());
        assertEquals(1, ab.size());
        ab.clear();
        assertEquals(0, ab.size());

    }
}
