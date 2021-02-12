package com.bensoft.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class LabApplication {

    private static final Logger log =
            LoggerFactory.getLogger(LabApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner demo(AddressBookRepository repo1, BuddyInfoRepository repo2) {
        return (args) -> {
            // save an address book
            AddressBook test = new AddressBook();
            BuddyInfo gary = new BuddyInfo("Gary", 123456789, "1 2nd Street");
            test.addBuddy(gary);
            repo1.save(test);
            log.info(test.toString());

            // fetch all buddies
            log.info("Address Books found with findAll():");
            log.info("-------------------------------");
            for (AddressBook ab : repo1.findAll()) {
                log.info(ab.toString());
            }
            log.info("");

            // fetch an individual address book by ID
            AddressBook ab = repo1.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(ab.toString());
            log.info("");

            // save a few buddies
            repo2.save(new BuddyInfo("Steve", 123456789, "1 2nd Street"));

            // fetch all buddies
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repo2.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual buddy by ID
            BuddyInfo buddy = repo2.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddy.toString());
            log.info("");

            // fetch buddies by name
            log.info("Buddy found with findByName('Steve'):");
            log.info("--------------------------------------------");
            repo2.findByName("Steve").forEach(steve -> log.info(steve.toString()));
            log.info("");
        };
    }
}
