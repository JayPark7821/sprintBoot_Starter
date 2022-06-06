package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    /***
     *  JPA는 EntityManger로 모든게 동작한다.
     *  스프링부트가 자동으로 EntityManager를 자동으로 생성해준다.
     *  주입만 받아서 사용하면 됨.
     */
    private EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();


    }

    @Override
    public List<Member> findAll() {
    /**
     * jpql
     * 보통은 db의 테이블 대상으로 쿼리를 날리지만
     * jpql은 객체를 대상 ( Entity) 으로 쿼리를 날린다.
     *
     * select 의 대상은 Entity객체 자체를 select 한다.
     */
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        //        List<Member> result = em.createQuery("select m from Member m", Member.class)
        //                .getResultList();
        //        return result;
        //        inline 단축키 ctrl + alt + n
    }
}
