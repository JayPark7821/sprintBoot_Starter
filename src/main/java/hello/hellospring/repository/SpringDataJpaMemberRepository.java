package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/***
 * interface가 interface를 받을때는 extends interface는 다중상속 가능.
 *
 * Spring Data Jpa가 JpaRepository를 extends하고 있으면 구현체를 자동으로 만들어서 bean에 등록해준다.
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    @Override
    Optional<Member> findByName(String name);
}
