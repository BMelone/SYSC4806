package com.bensoft.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RepositoryRestController
public class WebRepoController {
    private final AddressBookRepository repo1;

    @Autowired
    public WebRepoController(AddressBookRepository repo1) {
        this.repo1 = repo1;
    }

    @GetMapping(value="/addressBooks/{id}/buddyInfos")
    public ModelAndView getBuddies(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("buddies");

        AddressBook addressBook = repo1.findById(id);
        List<BuddyInfo> buddies = (List<BuddyInfo>) addressBook.getBuddyInfos();
        mv.addObject("buddies", buddies);
        mv.addObject("id", id);
        mv.addObject("buddy", new BuddyInfo());
        return mv;
    }

    @PostMapping(value="/addressBooks/{id}/buddyInfos")
    public String addedNewBuddyToAddressBook(@PathVariable("id") long id,
                                           @ModelAttribute BuddyInfo buddy,
                                           Model model) {
        model.addAttribute("id", id);
        model.addAttribute("buddy", buddy);

        AddressBook addressBook = repo1.findById(id);
        addressBook.addBuddy(buddy);
        repo1.save(addressBook);

        return "addBuddyToAddressBook";
    }

    @GetMapping(value="/addressBooks")
    public ModelAndView getAddressBooks() {
        ModelAndView mv = new ModelAndView("addressBooks");

        List<AddressBook> addressBooks = (List<AddressBook>) repo1.findAll();
        mv.addObject("addressBooks", addressBooks);
        return mv;
    }

    @PostMapping(value="/addressBooks")
    public String addedNewAddressBook() {
        repo1.save(new AddressBook());
        return "addAddressBook";
    }
}
