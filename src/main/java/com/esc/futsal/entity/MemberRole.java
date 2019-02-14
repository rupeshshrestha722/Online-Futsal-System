package com.esc.futsal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="tbl_member_role")
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberRoleId;

    @Column(name = "member_role_name")
    private String memberRoleName;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "memberRoleList")
    private List<Member> memberList;

    public MemberRole() {
    }

    public MemberRole(String memberRoleName, List<Member> memberList) {
        this.memberRoleName = memberRoleName;
        this.memberList = memberList;
    }

    public Long getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(Long memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    public String getMemberRoleName() {
        return memberRoleName;
    }

    public void setMemberRoleName(String memberRoleName) {
        this.memberRoleName = memberRoleName;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
