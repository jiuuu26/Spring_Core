package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService= appConfig.orderService();

        long memberId = 26L;
        Member member = new Member(memberId,"지우", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "치킨", 20000);

        System.out.println("order = "+order);
        System.out.println("discount order = "+order.calculatePrice());

    }
}
