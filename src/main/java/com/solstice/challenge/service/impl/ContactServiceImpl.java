package com.solstice.challenge.service.impl;

import com.solstice.challenge.domain.Contact;
import com.solstice.challenge.domain.ContactResponse;
import com.solstice.challenge.repository.ContactRepository;
import com.solstice.challenge.repository.PhoneNumberRepository;
import com.solstice.challenge.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    private static org.apache.log4j.Logger log = Logger.getLogger(Contact.class);

    @Override
    public Contact retrieveContactById(Long id) {
        return contactRepository.findByContactId(id);
    }

    @Override
    public Contact retrieveContactByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    @Override
    public Contact retrieveContactByPhone(String phone) {
        return contactRepository.findByContactId(phoneNumberRepository.findByNumber(phone));
    }

    @Override
    public List<Contact> retrieveContactsByCity(String city){
        return contactRepository.findByCity(city);
    }

    @Override
    public List<Contact> retrieveContactsByState(String state){
        return contactRepository.findByState(state);
    }

    @Override
    public ContactResponse createContact(Contact contact) {
        ContactResponse response = new ContactResponse();
        try{
            contactRepository.save(contact);
            // if save contact pass, then i'll return the OK response
            response.setContactid(contactRepository.findByEmail(contact.getEmail()).getContactId());
            String ok = "Contact created succesfully with id:"+response.getContactid();
            log.info(ok);
            response.setMessage(ok);
            response.setMessageType("OK");
            return response;
        }
        catch (Exception e){
            String error = "There was a problem trying to create a new contact";
            log.error(error, e);
            response.setContactid(null);
            response.setMessage(error);
            response.setMessageType("ERROR");
            return response;
        }
    }

    @Override
    public ContactResponse updateContact(Contact contact) {
        ContactResponse response = new ContactResponse();
        try{
            contactRepository.save(contact);
            // if save contact pass, then i'll return the OK response
            response.setContactid(contact.getContactId());
            String ok = "Contact id:"+contact.getContactId()+" was succesfully updated";
            log.info(ok);
            response.setMessage(ok);
            response.setMessageType("OK");
            return response;
        }
        catch (Exception e){
            String error = "There was a problem trying to update contact id: "+contact.getContactId();
            log.error(error, e);
            response.setContactid(null);
            response.setMessage(error);
            response.setMessageType("ERROR");
            return response;
        }
    }

    @Override
    public ContactResponse deleteContact(Long id) {
        ContactResponse response = new ContactResponse();
        try{
            Contact contact = contactRepository.findByContactId(id);
            contactRepository.delete(contact);
            // if delete contact pass, then i'll return the OK response
            response.setContactid(id);
            String ok = "Contact id:"+contact.getContactId()+" was succesfully deleted";
            log.info(ok);
            response.setMessage(ok);
            response.setMessageType("OK");
            return response;
        }
        catch (Exception e){
            String error = "There was a problem trying to delete contact id: "+id;
            log.error(error, e);
            response.setContactid(null);
            response.setMessage(error);
            response.setMessageType("ERROR");
            return response;
        }
    }

}
