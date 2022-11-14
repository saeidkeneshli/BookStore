package com.erp.repository;

import com.erp.common.JDBC;
import com.erp.entity.Book;
import com.erp.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public BookDA() throws Exception {
        this.connection = JDBC.getConnection();
    }

    public void insert(Book book) throws Exception {
        preparedStatement = connection.prepareStatement("select book_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        book.setId(resultSet.getLong("id"));

        preparedStatement = connection.prepareStatement("insert into book(id, name, writer) values (?,?,?)");
        preparedStatement.setLong(1, book.getId());
        preparedStatement.setString(2, book.getName());
        preparedStatement.setString(3, book.getWriter());
        preparedStatement.executeUpdate();
    }

    public void delete(Book book) throws Exception {
        preparedStatement = connection.prepareStatement("delete from book where id=?");
        preparedStatement.setLong(1, book.getId());
        preparedStatement.executeUpdate();
    }

    public Book select(String name) throws Exception {
        preparedStatement = connection.prepareStatement("select * from book where name=?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book result = null;
        if (resultSet.next()) {
            result = new Book()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setWriter(resultSet.getString("writer"));
        }
        return result;
    }

    public List<Book> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from book");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setWriter(resultSet.getString("writer"));
            bookList.add(book);
        }
        return bookList;
    }

    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
