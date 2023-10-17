package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();

    MemberService memberservice = AppConfig.memberService();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberservice.join(member);
        Member findMember = memberservice.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
