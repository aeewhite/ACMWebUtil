package edu.ua.cs.acm.controllers;

import edu.ua.cs.acm.repositories.MemberRepository;
import edu.ua.cs.acm.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jzarobsky on 9/4/17.
 */
@RestController
@RequestMapping("/members")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping()
    public ResponseEntity currentMember(@RequestParam("email") String email, @RequestParam("name") String name) {


        return ResponseEntity.ok().build();
    }
}
