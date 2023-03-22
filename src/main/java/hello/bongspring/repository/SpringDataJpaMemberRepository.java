package hello.bongspring.repository;

import hello.bongspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
    //JPOL select m from Member m where m.name = ?

}
