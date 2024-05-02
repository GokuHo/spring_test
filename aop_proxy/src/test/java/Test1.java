import org.junit.jupiter.api.Test;
import service.Impl.OrderServiceImpl;
import service.Impl.OrderServiceStaticProxy;
import service.JDKProxyInvocationHandler;
import service.OrderService;

import java.lang.reflect.Proxy;


public class Test1 {

    @Test
    public void StaticProxt() {
        OrderServiceImpl target = new OrderServiceImpl();
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy(target);

        proxy.method1();
        System.out.println(proxy.method2());
        System.out.println(proxy.method3());
    }

    @Test
    public void DynamicProxt() {
        OrderServiceImpl target = new OrderServiceImpl();
        OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new JDKProxyInvocationHandler(target));

        proxy.method1();

        String result2 = proxy.method2();
        System.out.println(result2);

        Object result3 = proxy.method3();
        System.out.println(result3);
    }
}
