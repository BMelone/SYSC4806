package com.bensoft.lab;

import javax.persistence.*;

/**
 * org.BenSoft.BuddyInfo represents the information of a buddy
 *
 * @author Benjamin Melone
 * @author 101034994
 */
@Entity
public class BuddyInfo {

    private String name;
    private long phoneNumber;
    private String address;
    private int age;
    private Long id;
    private AddressBook addressBook;

    public static void main(String[] args) {
        //System.out.println("Hello World! changed");
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("Homer");
        System.out.println("Hello " + buddy.getName());
    }

    public BuddyInfo() {
    }

    public BuddyInfo(String name, long phoneNumber, String address) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    public BuddyInfo(BuddyInfo copy) {
        setName(copy.getName());
        setPhoneNumber(copy.getPhoneNumber());
        setAddress(copy.getAddress());
        setAge(copy.getAge());
        setId(copy.getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        id = newId;
    }

    @ManyToOne
    public AddressBook getAddressBook() { return addressBook; }

    public void setAddressBook(AddressBook addressBook) { this.addressBook = addressBook; }

    @Transient
    public boolean isOver18() {
        return getAge() > 18;
    }

    @Override
    public String toString() {
        return id + " \n" + name + " \n" + phoneNumber + " \n" + address;
    }

    @Transient
    public String getGreeting() {
        return "Hello " + getName();
    }

}
