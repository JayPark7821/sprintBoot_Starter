package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 서비스는 비즈니스에 가까운 용어를 사용
 * 비즈니스에 의존적으로 설계를 한다.
 *
 * @Service는 스프링이 올라올때 스프링컨테이너에 해당
 * 어노테이션이 붙은 서비스를 등록하고 관리해준다.
 */
public class MemberService {


    // 단축키!! junit 테스트 생성 단축키 ctrl + shift + t
    private final MemberRepository memberRepository;

    // DI dependency injection

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        // Optional로 감싸놓아서 아래와같은 ifPresent를 사용할수있다.
//        result.ifPresent(m ->{
//            throw new IllegalStateException("이미 존재하는 회원이빈다.");
//        });

        // 단축키!! 동일한 단어 묶어서 수정 shift + f6
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //단축키!!  ctrl + alt + shift + T -> extract Method
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
