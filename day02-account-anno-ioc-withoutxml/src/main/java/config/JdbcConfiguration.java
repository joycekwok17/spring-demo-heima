package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/7/23
 */
public class JdbcConfiguration {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "runner") // 把当前方法的返回值作为bean对象存入spring的ioc容器中
    // name: 指定bean的id。当不写时，默认值是当前方法的名称 runner
    @Scope("prototype") // 指定bean的作用范围 singleton prototype request session globalSession
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/newDB?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("password");
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
