package startBack.springStart;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import startBack.springStart.repository.JpaMemberRepository;
import startBack.springStart.repository.MemberRepository;
import startBack.springStart.service.MemberService;

//자바코드로 Bean 직접등록 - 설정파일만 손대면 나중에 바꿀 때 편하다
//컴포넌트 스캔 자동 등록 - 필드 주입, setter 주입, 생성사 주입*
@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


//    private DataSource dataSource;

//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){


        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
