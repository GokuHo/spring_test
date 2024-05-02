import demon.config.TransactionConfig;
import demon.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:ioc.xml")
public class Test1 {

    @Test
    public void AnnotationTransactionTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.transfer(1, 2, 10);
    }

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.transfer(1, 2, 10);
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.setBalance();
    }

    @Test
    public void isolationTest1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.isolationTest();
    }

    @Test
    public void isolationTest2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService2", UserService.class);
        userService.setBalance();
    }

    @Test
    public void timeoutTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.timeoutTest();
    }

    @Test
    public void readonltTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.readonlyTest();
    }

    @Test
    public void rollbackforTest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.rollbackforTest();
    }

    @Test
    public void noRollbackforTest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.noRollbackforTest();
    }
}