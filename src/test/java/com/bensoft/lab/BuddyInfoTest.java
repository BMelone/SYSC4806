package com.bensoft.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuddyInfoTest {

    private String firstName;
    private long firstNumber;
    private String firstAddress;
    BuddyInfo guy;

    @BeforeEach
    public void setUp() {
        firstName = "Bob";
        firstNumber = 1234567891;
        firstAddress = "55 Road Drive";
        guy = new BuddyInfo(firstName, firstNumber, firstAddress);
    }

    @Test
    public void testCopy() {
        BuddyInfo second = new BuddyInfo(guy);
        assertEquals(firstName, second.getName());
        assertEquals(firstNumber, second.getPhoneNumber());
        assertEquals(firstAddress, second.getAddress());
    }

    @Test
    public void testGreeting() {
        assertEquals("Hello " + firstName, guy.getGreeting());
    }

    @Test
    public void testSetGetAge() {
        int age = 50;
        assertEquals(0, guy.getAge());
        guy.setAge(age);
        assertEquals(age, guy.getAge());
    }

    @Test
    public void testOver18() {
        guy.setAge(12);
        assertFalse(guy.isOver18());
        guy.setAge(18);
        assertFalse(guy.isOver18());
        guy.setAge(50);
        assertTrue(guy.isOver18());
    }
}

