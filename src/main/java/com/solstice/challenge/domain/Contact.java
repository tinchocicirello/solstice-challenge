package com.solstice.challenge.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;
    private String company;
    private String state;
    private String city;
    private String profileImageUrl;
    private String email;
    private Date birthdate;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="contact_id")
    private List<PhoneNumber> phones;


    public Long getContactId() { return contactId; }

    public void setContactId(Long id) { this.contactId = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhones() { return phones; }

    public void setPhones(List<PhoneNumber> phones) { this.phones = phones; }
}
