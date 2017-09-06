package edu.ua.cs.acm.services;

import edu.ua.cs.acm.domains.Member;

/**
 * Created by jzarobsky on 9/4/17.
 */
public interface MembershipService {

    int ONE_SEMESTER_MEMBERSHIP = 0;
    int TWO_SEMESTER_MEMBERSHIP = 1;

    Member addMember(Member member);
    Member findByEmail(String email);
}
