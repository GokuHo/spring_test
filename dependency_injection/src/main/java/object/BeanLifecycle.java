package object;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class BeanLifecycle implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean
{

    private String name;

    public BeanLifecycle() {
        System.out.println("1: Instantiation");
    }

    public void setName(String name) {
        System.out.println("2: Dependencies Injected");
        this.name = name;
    }

    public void initBean() {
        System.out.println("3: Initialization");
    }

    public void destroyBean() {
        System.out.println("5: Destruction");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3 Before Bean Name: " + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("3 Before Class Loader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3 Before Bean Factory: " + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3 After Properties Set: Initialization");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("5 Before: Destroying...");
    }
}
