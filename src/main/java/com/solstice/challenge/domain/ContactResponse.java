package com.solstice.challenge.domain;

public class ContactResponse {

    private Long Contactid;
    private String message;
    private String messageType;

    public Long getContactid() { return Contactid; }

    public void setContactid(Long contactid) { Contactid = contactid; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public String getMessageType() { return messageType; }

    public void setMessageType(String messageType) { this.messageType = messageType; }
}
