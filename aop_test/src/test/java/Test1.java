import annotation_aop.AOPAspect;
import annotation_aop.OrderService;
import annotation_aop.config.AOPConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void xmlTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        OrderService bean = applicationContext.getBean(OrderService.class);

//        bean.method1();
        String s = bean.method2();
    }

    @Test
    public void annotationTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        OrderService bean = applicationContext.getBean(OrderService.class);

//        bean.method1();
        String s = bean.method2();
    }
}
