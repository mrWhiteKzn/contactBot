package com.white.bot.repository;

import com.white.bot.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Contact entity.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {

    Contact findByName(String name);

    Contact findByNameAndPhone(String name, String phone);

    boolean existsByNameAndPhone(String name, String phone);

}
