package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();

    MemberService memberService =  AppConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder() {

        long memberId = 1;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 15000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1500);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(13500);

    }

}
