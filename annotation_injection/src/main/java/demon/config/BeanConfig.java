package demon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"demon.dao", "demon.service", "demon.controller"})
public class BeanConfig {
}
