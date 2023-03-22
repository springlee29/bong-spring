package hello.bongspring.service;

import hello.bongspring.domain.Member;
import hello.bongspring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
   @Autowired
   MemberService memberService;
   @Autowired
   MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();

        member.setName("hello2");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();

        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void dupleMember(){
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
       /* try{
            memberService.join(member2);
            fail("예외 발생");

        }catch(IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.  ");
        }*/
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
        Member member1 = new Member();
        member1.setName("lee");

        Long result = memberService.join(member1);

        Member mem2 = memberService.findOne(result).get();

        Assertions.assertThat(result).isEqualTo(mem2.getId());

    }

}