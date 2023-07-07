package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration class for Spring IoC container to manage beans.
 *
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
@Configuration // 指定当前类是一个配置类
@ComponentScan(basePackages = "org.example") // <context:component-scan base-package="org.example"/> in bean.xml file
@Import(JdbcConfiguration.class) // <import resource="classpath:jdbcConfig.xml"/> in bean.xml file
@PropertySource("classpath:jdbcConfig.properties")
// specify the properties file location for jdbc configuration, classpath: means the file is in the resources folder
public class SpringConfiguration {

}
