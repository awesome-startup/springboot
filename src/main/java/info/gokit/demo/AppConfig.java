package info.gokit.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    @DatabaseType("MYSQL")
    public UserDAO jdbcUserDAO() {
        return new JdbcUserDAO();
    }

    @Bean
    @DatabaseType("MONGO")
    public UserDAO mongoUserDAO() {
        return new MongoUserDAO();
    }
}
