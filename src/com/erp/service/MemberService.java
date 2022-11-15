package com.erp.service;

import com.erp.entity.Member;
import com.erp.repository.MemberDA;
import java.util.List;
public class MemberService {
    private final static MemberService MEMBER_SERVICE = new MemberService();

    private MemberService(){
    }

    public static MemberService getMemberServiceInstance(){
        return MEMBER_SERVICE;
    }

    public void save(Member member) throws Exception {
        try (MemberDA memberDA = new MemberDA()) {
            memberDA.insert(member);
            memberDA.commit();
        }
    }

    public List<Member> findAll() throws Exception {
        try (MemberDA memberDA = new MemberDA()) {
            return memberDA.selectAll();
        }
    }

}
