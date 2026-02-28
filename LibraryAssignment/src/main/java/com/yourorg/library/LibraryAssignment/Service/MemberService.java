package com.yourorg.library.LibraryAssignment.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.yourorg.library.LibraryAssignment.Entites.Member;
import com.yourorg.library.LibraryAssignment.Exception.ResourceNotFoundException;
import com.yourorg.library.LibraryAssignment.Repositories.MemberRepository;


@Service
public class MemberService {

    @Autowired private MemberRepository memberRepo;

    public Member addMember(Member member) {
        member.setStatus("ACTIVE");
        return memberRepo.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
    }

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Member updateMember(Long id, Member updated) {

        Member member = getMemberById(id);

        if (updated.getName() != null)
            member.setName(updated.getName());

        if (updated.getPhone() != null)
            member.setPhone(updated.getPhone());

        return memberRepo.save(member);
    }

    public void blockMember(Long id) {
        Member member = getMemberById(id);
        member.setStatus("BLOCKED");
        memberRepo.save(member);
    }
}