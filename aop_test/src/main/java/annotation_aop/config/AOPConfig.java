package annotation_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("annotation_aop")
@EnableAspectJAutoProxy
public class AOPConfig {
}
