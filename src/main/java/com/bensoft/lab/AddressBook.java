package com.bensoft.lab;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * org.BenSoft.AddressBook class serves as a collection of BuddyInfos
 *
 * @author Benjamin Melone
 * @author 101034994
 */
@Entity
public class AddressBook {

    Collection<BuddyInfo> buddyInfos;
    private Long id;

    public static void main(String[] args) {
        System.out.println("Address Book");
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Steve", 987654321, "2 1st Street");
        BuddyInfo buddy2 = new BuddyInfo("Bob", 123456789, "1 2nd Street");
        book.addBuddy(buddy);
        book.addBuddy(buddy2);
        System.out.println(book);
        book.removeBuddy(buddy);
    }

    public AddressBook() {
        buddyInfos = new ArrayList<>();
    }

    public boolean removeBuddy(BuddyInfo buddy) {
        buddy.setAddressBook(null);
        return getBuddyInfos().remove(buddy);
    }

    public boolean addBuddy(BuddyInfo buddy) {
        buddy.setAddressBook(this);
        return getBuddyInfos().add(buddy);
    }

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    public void setBuddyInfos(Collection<BuddyInfo> buddies) {
        this.buddyInfos = buddies;
    }

    public int size() {
        return getBuddyInfos().size();
    }

    public void clear() {
        getBuddyInfos().clear();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        id = newId;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("ADDRESS BOOK CONTENTS:\n");
        int i = 1;
        if (getBuddyInfos() != null)
        for (Object o : getBuddyInfos()) {
            out.append("Buddy #").append(i).append(":\n");
            out.append(o).append("\n");
            i++;
        }
        return out.toString();
    }
}

