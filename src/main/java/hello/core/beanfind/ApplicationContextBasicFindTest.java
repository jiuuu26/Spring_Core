package hello.core.beanfind;


import hello.core.member.MemberService;
import hello.core.order.AppConfig;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
/*
    @Test
    @DisplayName("빈 이름으로 조회")
    void  findByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

    }*/

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByName(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));

    }
}
