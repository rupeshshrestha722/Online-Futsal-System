package com.esc.futsal.service;

import com.esc.futsal.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMember();
    void addMember(Member member);
    void updateMember(Member member);
    Member getById(Long id);
    void deleteMember(Long id);
    Member findByUsername(String username);
}
