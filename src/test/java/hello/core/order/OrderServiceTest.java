package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 26L;
        Member member = new Member(memberId,"지우", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "치킨", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
