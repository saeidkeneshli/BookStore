package com.erp.entity;

public class History {
    long memberId, bookId;
    String hdate;

    public History() {
    }

    public History(long memberId, long bookId, String hdate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.hdate = hdate;
    }

    public long getMemberId() {
        return memberId;
    }

    public History setMemberId(long memberId) {
        this.memberId = memberId;
        return this;
    }

    public long getBookId() {
        return bookId;
    }

    public History setBookId(long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getHdate() {
        return hdate;
    }

    public History setHdate(String hdate) {
        this.hdate = hdate;
        return this;
    }
}
