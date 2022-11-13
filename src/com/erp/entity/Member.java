package com.erp.entity;

public class Member {
    long id;
    String melliCode, name, family;

    public Member() {
    }

    public Member(String melliCode, String name, String family) {
        this.melliCode = melliCode;
        this.name = name;
        this.family = family;
    }

    public Member(long id, String melliCode, String name, String family) {
        this.id = id;
        this.melliCode = melliCode;
        this.name = name;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public Member setId(long id) {
        this.id = id;
        return this;
    }

    public String getMelliCode() {
        return melliCode;
    }

    public Member setMelliCode(String melliCode) {
        this.melliCode = melliCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Member setFamily(String family) {
        this.family = family;
        return this;
    }
}
