package hello.bongspring;

import hello.bongspring.repository.JpaMemberRepository;
import hello.bongspring.repository.MemberRepository;
import hello.bongspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

   private final DataSource dataSource;

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        return new JpaMemberRepository(em);
        //return new MemoryMemberRepository();
    }
}
