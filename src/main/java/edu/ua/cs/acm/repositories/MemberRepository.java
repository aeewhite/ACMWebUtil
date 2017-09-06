package edu.ua.cs.acm.repositories;

import edu.ua.cs.acm.domains.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jzarobsky on 9/4/17.
 */
public interface MemberRepository extends MongoRepository<Member, String> {
    Member findByEmail(String email);
}
