package com.white.bot.service.impl;

import com.white.bot.domain.Contact;
import com.white.bot.repository.ContactRepository;
import com.white.bot.service.ContactService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Service Implementation for managing Contacts.
 * It may gets a {@link Contact} or contacts parameters.
 * It returns a {@link Contact} or {@link Boolean} in case of checking existing contact.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact findByName(String name) {
        return contactRepository.findByName(name);
    }

    @Override
    public Contact findByNameAndPhone(String name, String phone) {
        return contactRepository.findByNameAndPhone(name, phone);
    }

    @Override
    public boolean exitsByNameAndPhone(String name, String phone) {
        return contactRepository.existsByNameAndPhone(name, phone);
    }

    @Override
    public void delete(Contact contact) {
        contact = contactRepository.findByName(contact.getName());
        contactRepository.delete(contact);
    }
}
