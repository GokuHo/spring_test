package service.Impl;

import service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public void method1() {
        System.out.println("OrderService -> method 1");
    }

    @Override
    public String method2() {
        System.out.println("OrderService -> method 2");
        return "String return value";
    }

    @Override
    public Object method3() {
        System.out.println("OrderService -> method 3");
        return 100;
    }
}
