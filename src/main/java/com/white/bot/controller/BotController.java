package com.white.bot.controller;

import com.white.bot.controller.errors.ContactExistException;
import com.white.bot.domain.Command;
import com.white.bot.domain.Contact;
import com.white.bot.service.ContactService;
import org.springframework.stereotype.Controller;

/**
 * Controller to manage bot's command
 */
@Controller
public class BotController {

    private ContactService contactService;

    public BotController(ContactService contactService) {
        this.contactService = contactService;
    }

    public Contact save(Command command) {
        Contact contact = new Contact()
                .name(command.getName())
                .phone(command.getPhone())
                .company(command.getCompany());
        if (!isExist(contact)) {
            return contactService.save(contact);
        }
        throw new ContactExistException();
    }

    private boolean isExist(Contact contact) {
        return contactService.exitsByNameAndPhone(contact.getName(), contact.getPhone());
    }

    public Contact find(Command command) {
        return contactService.findByName(command.getName());
    }

    public void update(Command command) {
        Contact contact = contactService.findByNameAndPhone(command.getName(), command.getPhone());
        contact.setPhone(command.getPhone());
        contact.setCompany(command.getCompany());
        contactService.save(contact);
    }

    public void delete(Command command) {
        Contact contact = new Contact()
                .name(command.getName())
                .phone(command.getPhone());
        contactService.delete(contact);
    }
}
