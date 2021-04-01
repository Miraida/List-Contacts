package com.geek.listcontacts.model;

import java.io.Serializable;

public class ContactModel implements Serializable {
    String name;
    String number;

    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
