package com.solstice.challenge.controller;

import com.solstice.challenge.ChallengeApplication;
import com.solstice.challenge.controller.v1.ContactController;
import com.solstice.challenge.domain.Contact;
import com.solstice.challenge.repository.ContactRepository;
import com.solstice.challenge.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;


    @Test
    public void getContactRecordByGivenId() throws Exception {

        Contact contact = new Contact();
        contact.setContactId((long)1);

        given(contactService.retrieveContactById(contact.getContactId())).willReturn(contact);

        mockMvc.perform(get("/v1/contacts/id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.contactId", isA(Number.class)))
                .andExpect(jsonPath("$.address", is(contact.getAddress())))
                .andExpect(jsonPath("$.city", is(contact.getCity())))
                .andExpect(jsonPath("$.state", is(contact.getState())))
                .andExpect(jsonPath("$.email", is(contact.getEmail())))
                .andExpect(jsonPath("$.phones", is(contact.getPhones())))
                .andExpect(jsonPath("$.name", is(contact.getName())))
                .andExpect(jsonPath("$.company",is(contact.getCompany())))
                .andExpect(jsonPath("$.birthdate", is(contact.getBirthdate())))
                .andExpect(jsonPath("$.profileImageUrl", is(contact.getProfileImageUrl())));
    }

    @Test
    public void getContactRecordByGivenEmail() throws Exception {

        Contact contact = new Contact();
        contact.setEmail("test@test.com");

        given(contactService.retrieveContactByEmail(contact.getEmail())).willReturn(contact);

        mockMvc.perform(get("/v1/contacts/email/"+contact.getEmail())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.contactId", is(contact.getContactId())))
                .andExpect(jsonPath("$.address", is(contact.getAddress())))
                .andExpect(jsonPath("$.city", is(contact.getCity())))
                .andExpect(jsonPath("$.state", is(contact.getState())))
                .andExpect(jsonPath("$.email", is(contact.getEmail())))
                .andExpect(jsonPath("$.phones", is(contact.getPhones())))
                .andExpect(jsonPath("$.name", is(contact.getName())))
                .andExpect(jsonPath("$.company",is(contact.getCompany())))
                .andExpect(jsonPath("$.birthdate", is(contact.getBirthdate())))
                .andExpect(jsonPath("$.profileImageUrl", is(contact.getProfileImageUrl())));
    }
}
