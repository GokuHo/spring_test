package service.Impl;

import service.OrderService;

public class OrderServiceStaticProxy implements OrderService {

    private OrderService orderService;
    public OrderServiceStaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void method1() {
        orderService.method1();
        System.out.println("static proxy");
    }

    @Override
    public String method2() {
        orderService.method2();
        System.out.println("static proxy");
        return "static proxy return value";
    }

    @Override
    public Object method3() {
        orderService.method3();
        System.out.println("static proxy");
        return "static proxy return value";
    }
}
