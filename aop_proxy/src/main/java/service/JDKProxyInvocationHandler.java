package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public JDKProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK dynamic invoke method");
        Object result = method.invoke(target, args);
        return result;
    }
}
