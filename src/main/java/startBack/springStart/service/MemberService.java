package startBack.springStart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import startBack.springStart.domain.Member;
import startBack.springStart.repository.MemberRepository;
import startBack.springStart.repository.MemoryMemberRepository;

import java.util.*;

@Transactional
public class MemberService {

    //private final MemberRepository memberRepository = new MemberRepository(); -> 이렇게 하면 의존성 주입이 안됨
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     *
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 X

        long start = System.currentTimeMillis();

        try {


            validateDuplicateMember(member); // 중복 회원 검증

            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("시간  : " + timeMs );

        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
           throw new IllegalStateException("이미 존재하는 회원입니다.");
       });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
       return  memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
