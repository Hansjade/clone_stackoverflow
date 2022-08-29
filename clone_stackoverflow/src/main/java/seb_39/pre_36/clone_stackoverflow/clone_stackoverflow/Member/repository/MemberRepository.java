package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByEmail(String email);
}
