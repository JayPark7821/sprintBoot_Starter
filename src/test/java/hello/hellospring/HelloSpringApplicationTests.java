package hello.hellospring;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HelloSpringApplicationTests {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	//각각 테스트가 끝나고 나서 호출됨
	@AfterEach
	public void afterEach(){
		repository.clearStore();
	}

	@Test
	public void save(){
		Member member = new Member();
		member.setName("spring!");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		assertThat(member).isEqualTo(result);
	}

	@Test
	public void findByName(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring2").get();

		assertThat(result).isEqualTo(member2);
	}

	@Test
	public void findAll(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		List<Member> result = repository.findAll();

		assertThat(result.size()).isEqualTo(2);

	}

	@Test
	void contextLoads() {
	}

}
