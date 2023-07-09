package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
@Configuration // indicate this is a configuration class
@ComponentScan(basePackages = "org.example") // scan all components under org.example
@Import({JdbcConfig.class, TransactionConfig.class}) // import other configuration files
@PropertySource("classpath:jdbc.properties") // import jdbc.properties
@EnableTransactionManagement // enable transaction management
public class SpringConfiguration {
}
