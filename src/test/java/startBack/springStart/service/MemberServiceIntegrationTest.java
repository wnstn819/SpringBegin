package startBack.springStart.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import startBack.springStart.domain.Member;
import startBack.springStart.repository.MemberRepository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //테스트를 여러번 할 수 있게끔 실제 DB에는 안들어감 - rollback 해줌
public class MemberServiceIntegrationTest {
    @Autowired  MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given - 뭔가가 주어졌을 때
        Member member = new Member();
        member.setName("spring");

        //when - 이것을 실행했을 때
        Long saveId = memberService.join(member);


        //then - 이게 나와야 된다.
        Member findMember =memberService.findOne(saveId).get();
        // Assertions , options + enter
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);
        IllegalStateException e =  assertThrows(IllegalStateException.class, ()-> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");



        //then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
