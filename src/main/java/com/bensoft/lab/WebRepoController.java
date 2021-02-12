package com.bensoft.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RepositoryRestController
public class WebRepoController {
    private final AddressBookRepository repo1;


    @Autowired
    public WebRepoController(AddressBookRepository repo1) {
        this.repo1 = repo1;
    }

    @GetMapping(value = "/addressBooks/{id}/buddyInfos")
    public ModelAndView getBuddies(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("buddies");

        AddressBook addressBook = repo1.findById(id);
        List<BuddyInfo> buddies = (List<BuddyInfo>) addressBook.getBuddyInfos();
        mv.addObject("buddies", buddies);

        return mv;
    }
}
