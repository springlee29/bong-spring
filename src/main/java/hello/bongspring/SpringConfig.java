package hello.bongspring;

import hello.bongspring.aop.TimeTraceAop;
import hello.bongspring.repository.MemberRepository;
import hello.bongspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    //private final DataSource dataSource;

    //private final EntityManager em;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }


    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

}
