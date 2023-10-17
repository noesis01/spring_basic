package hello.core;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.Grade;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = AppConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(findMember.getName());

    }
}
