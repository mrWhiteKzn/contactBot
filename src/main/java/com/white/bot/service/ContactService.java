package com.white.bot.service;

import com.white.bot.domain.Contact;

public interface ContactService {

    /**
     * Save a contact/
     *
     * @param contact is user to save.
     * @return the persisted entity.
     */
    Contact save(Contact contact);

    /**
     * Find contact by name.
     *
     * @param name is for finding.
     * @return the found entity.
     */
    Contact findByName(String name);

    /**
     * Find a contact by name and phone.
     *
     * @param name
     * @param phone
     * @return
     */
    Contact findByNameAndPhone(String name, String phone);

    /**
     * Check existing a contact with same name and phone
     *
     * @param name
     * @param phone
     * @return
     */
    boolean exitsByNameAndPhone(String name, String phone);

    /**
     * Delete a contact/
     *
     * @param contact
     */
    void delete(Contact contact);
}
