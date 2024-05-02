package annotation_aop.impl;

import annotation_aop.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public void method1() {
        System.out.println("OrderService -> method 1");
    }

    @Override
    public String method2() {
        System.out.println("OrderService -> method 2");
//        System.out.println(1/0);
        return "String return value";
    }

    @Override
    public Object method3() {
        System.out.println("OrderService -> method 3");
        return 100;
    }
}
