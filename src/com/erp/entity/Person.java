package com.erp.entity;

public class Person {
    long id;
    String melliCode, name, family;

    public Person() {
    }

    public Person(String melliCode, String name, String family) {
        this.melliCode = melliCode;
        this.name = name;
        this.family = family;
    }

    public Person(long id, String melliCode, String name, String family) {
        this.id = id;
        this.melliCode = melliCode;
        this.name = name;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getMelliCode() {
        return melliCode;
    }

    public Person setMelliCode(String melliCode) {
        this.melliCode = melliCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
