package edu.ua.cs.acm.domains;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * Created by jzarobsky on 9/4/17.
 */
@Document
public class Member {

    private String firstName;
    private String lastName;

    @Indexed
    private String email;
    private String shirtSize;

    private Instant membershipStartDate;
    private Instant membershipEndDate;
}
