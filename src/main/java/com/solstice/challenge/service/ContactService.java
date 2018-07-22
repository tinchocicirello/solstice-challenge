package com.solstice.challenge.service;

import com.solstice.challenge.domain.Contact;
import com.solstice.challenge.domain.ContactResponse;

import java.util.List;

public interface ContactService {

    Contact retrieveContactById(Long id);
    Contact retrieveContactByEmail(String email);
    Contact retrieveContactByPhone(String phone);
    List<Contact> retrieveContactsByCity(String city);
    List<Contact> retrieveContactsByState(String state);
    ContactResponse createContact(Contact contact);
    ContactResponse updateContact(Contact contact);
    ContactResponse deleteContact(Long id);


}
