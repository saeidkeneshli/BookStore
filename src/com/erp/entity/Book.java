package com.erp.entity;

public class Book {
    long id;
    String name, writer;

    public Book() {
    }

    public Book(long id, String name, String writer) {
        this.id = id;
        this.name = name;
        this.writer = writer;
    }

    public long getId() {
        return id;
    }

    public Book setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public Book setWriter(String writer) {
        this.writer = writer;
        return this;
    }
}
