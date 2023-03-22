package hello.bongspring;

import hello.bongspring.repository.MemberRepository;
import hello.bongspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

/*    @Bean
    public MemberRepository memberRepository(){

        //return new JpaMemberRepository(em);
        //return new MemoryMemberRepository();
    }*/
}
