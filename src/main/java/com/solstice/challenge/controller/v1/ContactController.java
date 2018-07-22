package com.solstice.challenge.controller.v1;

import com.solstice.challenge.domain.Contact;
import com.solstice.challenge.domain.ContactResponse;
import com.solstice.challenge.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/contacts/")
@Api(description = "Operations for contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "Find contact by ID", notes = "Retrieves a unique contact record from specific ID")
    @GetMapping("id/{contactId}")
    public Contact getContactById(
            @PathVariable("contactId") Long id){
        return contactService.retrieveContactById(id);
    }

    @ApiOperation(value = "Find contact by Email", notes = "Retrieves a unique contact record from specific Email")
    @GetMapping("email/{email}")
    public Contact getContactByEmail(
            @PathVariable("email") String email){
        return contactService.retrieveContactByEmail(email);
    }

    @ApiOperation(value = "Search contacts by City", notes = "Retrieves a list of contacts from specific City")
    @GetMapping("city/{city}")
    public List<Contact> getContactByCity(
            @PathVariable("city") String city){
        return contactService.retrieveContactsByCity(city);
    }

    @ApiOperation(value = "Search contacts by State", notes = "Retrieves a list of contacts from specific State")
    @GetMapping("state/{state}")
    public List<Contact> getContactByState(
            @PathVariable("state") String state){
        return contactService.retrieveContactsByState(state);
    }

    @ApiOperation(value = "Find contact by Phone", notes = "Retrieves a unique contact record from specific Phone")
    @GetMapping("phone/{phone}")
    public Contact getContactByPhone(
            @PathVariable("phone") String phone){
        return contactService.retrieveContactByPhone(phone);
    }

    @ApiOperation(value = "Create a new contact record", notes = "Create a new contact record")
    @PostMapping("create")
    public ContactResponse createNewContact(
            @RequestBody Contact contact){
        return contactService.createContact(contact);
    }

    @ApiOperation(value = "Update contact record", notes = "Update specific contact record by ID")
    @PutMapping("update/{contactId}")
    public ContactResponse updateContact(
            @PathVariable("contactId") Long id,
            @RequestBody Contact contact){
            contact.setContactId(id);
        return contactService.updateContact(contact);
    }

    @ApiOperation(value = "Delete contact record", notes = "Delete specific contact record by ID")
    @DeleteMapping("delete/{contactId}")
    public ContactResponse deleteContact(
            @PathVariable("contactId") Long id){
        return contactService.deleteContact(id);
    }

}
