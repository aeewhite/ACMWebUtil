package edu.ua.cs.acm.services.impl;

import edu.ua.cs.acm.domains.Member;
import edu.ua.cs.acm.repositories.MemberRepository;
import edu.ua.cs.acm.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;

/**
 * Created by jzarobsky on 9/4/17.
 */
@Service
public class MembershipServiceImpl implements MembershipService {

    private final MemberRepository memberRepository;

    @Autowired
    public MembershipServiceImpl(MemberRepository repository) {
        memberRepository = repository;
    }

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

//    public static Period getMembershipPeriod(int membershipType) {
//        LocalDate now = LocalDate.now();
//        Interval fallPeriod = Period.between(LocalDate.of(now.getYear(), Month.AUGUST, 1),
//                LocalDate.of(now.getYear(), Month.DECEMBER, 31));
//
//        if(fallPeriod.)
//
//        // BETWEEN 8/1 - 12/31 -> Fall Membership
//        // BETWEEN 1/1 - 7/31 -> Spring Membership
//
//
//        // Membebership Type = ONE_SEMESTER_MEMBERSHIP Semester in Fall Membership:
//        // 8/1 - 12-31
//
//        // Membebership Type = ONE_SEMESTER_MEMBERSHIP Semester in Spring Membership:
//        // 1/1 - 7-31
//
//        // Membership Type = TWO_SEMESTER_MEMBERSHIP Semester in Fall Membership
//        // 8/1/YYYY-7/31/YYYY+1
//
//        // Membership Type = TWO_SEMESTER_MEMBERSHIP Semester in Spring Membership:
//        // 1/1 - 12/31
//
//        return Period.between(now, now);
//    }

//    private static Period getMembershipPeriodFall(int membershipType) {
//
//    }
//
//    private static Period getMembershipPeriodSpring(int membershipType) {
//
//    }
}
