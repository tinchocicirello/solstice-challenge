package com.solstice.challenge.domain;

import javax.persistence.*;

@Entity(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String number;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getType() {
        return type;
    }

    public void setType(String type) { this.type = type; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
