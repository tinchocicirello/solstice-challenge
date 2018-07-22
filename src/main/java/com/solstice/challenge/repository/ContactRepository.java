package com.solstice.challenge.repository;

import com.solstice.challenge.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long>{

    Contact findByContactId(Long id);
    Contact findByEmail(String email);
    List<Contact> findByCity(String city);
    List<Contact> findByState(String state);

}
