package com.esc.futsal.service.impl;


import com.esc.futsal.entity.Member;
import com.esc.futsal.repository.MemberRepository;
import com.esc.futsal.service.MemberService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberServiceImpl implements MemberService {

private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository mRepository)
    {
        memberRepository = mRepository;
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public void addMember(Member member) {

        memberRepository.save(member);

    }

    @Override
    public void updateMember(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member getById(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public void deleteMember(Long id) {
         memberRepository.delete(id);
    }

    @Override
    public Member findByUsername(String username) {

        return memberRepository.findByUsername(username);
    }
}
