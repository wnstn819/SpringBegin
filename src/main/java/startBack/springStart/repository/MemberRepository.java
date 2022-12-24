package startBack.springStart.repository;

import startBack.springStart.domain.Member;

import java.util.*;

public interface MemberRepository {
    Member save(Member member); // 저장소에 저장
    Optional<Member> findById(Long id); // 아이디로 찾기
    Optional<Member> findByName(String name); // 이름으로 찾기
    List<Member> findAll(); // 전부
}
