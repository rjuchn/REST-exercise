package com.juchnicki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Rafal on 2016-12-04.
 */
@XmlRootElement
@Entity(name = "MESSAGE")
public class Message {
    @Id
    @Column(name="MESSAGE_ID")
    private long id;
    @Column(name="MESSAGE_VALUE")
    private String message;
    @Column(name="CREATION_DATE")
    private Date created;
    @Column(name="CREATOR")
    private String author;

    public Message() {
    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
