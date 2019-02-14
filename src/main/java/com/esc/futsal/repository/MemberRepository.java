package com.esc.futsal.repository;

import com.esc.futsal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
       Member findByUsername(String username);




        }
