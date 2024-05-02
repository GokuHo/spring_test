import demon.config.BeanConfig;
import demon.object.User;
import demon.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void filterTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_filter.xml");
    }

    @Test
    public void autowiredTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_autowired_resource.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        userController.add();
    }

    @Test
    public void componentScanTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        UserController userController = applicationContext.getBean(UserController.class);
        userController.add();
    }
}
