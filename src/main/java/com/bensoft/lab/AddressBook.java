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

    @OneToMany(mappedBy = "addressBook", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Collection<BuddyInfo> buddyInfos;
    @Id
    @GeneratedValue
    private Long id;

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

