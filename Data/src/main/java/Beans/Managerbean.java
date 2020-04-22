package Beans;

import dao.DatabasePool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class Managerbean {
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager()
    {
        return new DataSourceTransactionManager(DatabasePool.getHikariDataSource());
    }
}
