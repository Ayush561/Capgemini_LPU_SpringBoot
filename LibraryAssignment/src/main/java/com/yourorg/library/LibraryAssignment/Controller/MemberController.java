package com.yourorg.library.LibraryAssignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.yourorg.library.LibraryAssignment.Entites.Member;
import com.yourorg.library.LibraryAssignment.Service.MemberService;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired private MemberService service;

    @PostMapping
    public Member add(@RequestBody Member member) {
        return service.addMember(member);
    }

    @GetMapping("/{id}")
    public Member get(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @GetMapping
    public List<Member> getAll() {
        return service.getAllMembers();
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member updated) {
        return service.updateMember(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.blockMember(id);
    }
}