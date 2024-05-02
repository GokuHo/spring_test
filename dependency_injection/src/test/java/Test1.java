import object.*;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserServiceConstructorInjection;
import service.UserServiceSetterInjection;
import util.MysqlDataSource;
import util.MysqlDataSource2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void log4j2Test() throws Exception {
        logger.trace("log4j2 trace");
        logger.debug("log4j2 debug");
        logger.info("log4j2 info");
        logger.warn("log4j2 warn");
        logger.error("log4j2 error");
    }
    
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        Object userBean = applicationContext.getBean("userBean");
        User user1 = (User) userBean;
        User user2 = applicationContext.getBean("userBean", User.class); // Singleton, Only one bean named User
        User user3 = applicationContext.getBean(User.class);

        System.out.println(user1 == user2 && user2 == user3);

        Object dateBean = applicationContext.getBean("dateBean");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf(sdf.format((Date) dateBean));
    }

    @Test
    public void constructorInflectionTest1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_constructor_injection.xml");
        UserServiceConstructorInjection userServiceConstructorInjection = applicationContext.getBean("userServiceBean", UserServiceConstructorInjection.class);
        userServiceConstructorInjection.saveUser();
    }

    @Test
    public void setterInflectionTest1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter_injection.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);

        Employee employee = applicationContext.getBean("employeeBean", Employee.class);
        System.out.println(employee);
    }

    @Test
    public void setterInflectionTest2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter_injection2.xml");
        InjectionTest injectionTestBean = applicationContext.getBean("injectionTestBean", InjectionTest.class);
        System.out.println(injectionTestBean);
    }

    @Test
    public void setterInflectionUtilTest1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter_injection_util.xml");
        MysqlDataSource mysqlDataSource1 = applicationContext.getBean("mysqlBean1", MysqlDataSource.class);
        System.out.println(mysqlDataSource1);

        MysqlDataSource mysqlDataSource2 = applicationContext.getBean("mysqlBean1", MysqlDataSource.class);
        System.out.println(mysqlDataSource2);

        System.out.println(mysqlDataSource1 == mysqlDataSource2);
    }

    @Test
    public void setterInflectionUtilTest2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter_injection_util2.xml");
        MysqlDataSource2 mysqlDataSource2 = applicationContext.getBean("mysqlBean", MysqlDataSource2.class);
        System.out.println(mysqlDataSource2);
    }

    @Test
    public void setterInflectionPCTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter_injection_p_and_c.xml");
        User user1 = applicationContext.getBean("userBean1", User.class);
        User user2 = applicationContext.getBean("userBean2", User.class);
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    public void setterInflectionAotuwiredTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter_injection_autowired.xml");
        UserServiceSetterInjection userServiceSetterInjection = applicationContext.getBean("userService", UserServiceSetterInjection.class);
        userServiceSetterInjection.saveUser();
    }

    @Test
    public void circularDependencyTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_circular_dependency.xml");
        Wife wife = applicationContext.getBean("wifeBean", Wife.class);
        Husband husband = applicationContext.getBean("husbandBean", Husband.class);

        System.out.println(wife);
        System.out.println(husband);
    }

    @Test
    public void factoryBeanTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory_bean.xml");
        User user1 = applicationContext.getBean("userBean1", User.class);
        System.out.println(user1);

        Date date1 = applicationContext.getBean("dateBean1", Date.class);
        System.out.println(date1);

        User user2 = applicationContext.getBean("userBean2", User.class);
        System.out.println(user2);
    }

    @Test
    public void newObjectToBean() {
        User user1 = new User();
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("userBean", user1);

        User user2 = factory.getBean("userBean", User.class);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    @Test
    public void beanLifecycleTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_lifecycle.xml");
        BeanLifecycle beanLifecycle = applicationContext.getBean("beanLifecycle", BeanLifecycle.class);
        System.out.println("4: Using -> " + beanLifecycle);
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }
}
