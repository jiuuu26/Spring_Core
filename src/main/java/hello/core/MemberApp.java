package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
       // MemberService memberService = new MemberServiceImpl();
        Member member = new Member(26L, "지우", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(26L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
