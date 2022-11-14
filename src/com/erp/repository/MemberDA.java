package com.erp.repository;

import com.erp.common.JDBC;
import com.erp.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public MemberDA() throws Exception {
        this.connection = JDBC.getConnection();
    }

    public void insert(Member member) throws Exception {
        preparedStatement = connection.prepareStatement("select member_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        member.setId(resultSet.getLong("id"));

        preparedStatement = connection.prepareStatement("insert into member(id, mellicode, name, family) values (?,?,?,?)");
        preparedStatement.setLong(1, member.getId());
        preparedStatement.setString(2, member.getMelliCode());
        preparedStatement.setString(3, member.getName());
        preparedStatement.setString(4, member.getFamily());
        preparedStatement.executeUpdate();
    }

    public void delete(Member member) throws Exception {
        preparedStatement = connection.prepareStatement("delete from member where id=?");
        preparedStatement.setLong(1, member.getId());
        preparedStatement.executeUpdate();
    }


    public Member select(String codeMelli) throws Exception {
        preparedStatement = connection.prepareStatement("select * from member where mellicode=?");
        preparedStatement.setString(1, codeMelli);
        ResultSet resultSet = preparedStatement.executeQuery();
        Member result = null;
        if(resultSet.next()) {
            result = new Member()
                    .setId(resultSet.getLong("id"))
                    .setMelliCode(resultSet.getString("mellicode"))
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"));
        }
        return result;
    }

    public List<Member> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from member");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Member> memberList = new ArrayList<>();
        while (resultSet.next()) {
            Member member = new Member()
                    .setId(resultSet.getLong("id"))
                    .setMelliCode(resultSet.getString("mellicode"))
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"));
            memberList.add(member);
        }
        return memberList;
    }

    public void commit() throws Exception{
        connection.commit();
    }
    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
