package hello.bongspring;

import hello.bongspring.repository.MemberRepository;
import hello.bongspring.repository.MemoryMemberRepository;
import hello.bongspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        return new MemoryMemberRepository();
    }
}
