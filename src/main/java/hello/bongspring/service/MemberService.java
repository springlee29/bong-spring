package hello.bongspring.service;

import hello.bongspring.domain.Member;
import hello.bongspring.repository.MemberRepository;
import hello.bongspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private final MemberRepository memberRepository;
    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    * 회원 가입
    * */
    public Long join(Member member){
        //중복 회원 x
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 아이디 조회
     **/
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
