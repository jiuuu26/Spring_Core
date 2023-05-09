package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_success(){
        //given
        Member itsme = new Member(26L, "jiu", Grade.VIP);
        //when
        int discount = discountPolicy.discount(itsme, 25000);
        //then
        assertThat(discount).isEqualTo(2500);
    }

    @Test
    @DisplayName("BASIC은 할인이 적용되지 않아야 한다")
    void basic_success(){
        //given
        Member itsyou = new Member(2L, "whoareyou",Grade.BASIC);
        //when
        int discount = discountPolicy.discount(itsyou, 32000);
        //then
        assertThat(discount).isEqualTo(0);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_fail(){
        //given
        Member who = new Member(6L, "who", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(who, 35400);
        //then
        assertThat(discount).isEqualTo(0);
    }


}