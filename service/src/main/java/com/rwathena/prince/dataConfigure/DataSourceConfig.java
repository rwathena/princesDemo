package com.rwathena.prince.dataConfigure;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ Author:     prince.
 * @ Date：      Created in 3:38 PM 12/12/2018
 * @ Description:
 * @ Version:     1.0
 */
@Configuration
@MapperScan(basePackages = {"com.rwathena.netWorkEntity.*"},
        sqlSessionFactoryRef = "dataSqlSessionFactory")
public class DataSourceConfig {

    /** Field description */
    static final String MAPPER_LOCATION = "classpath:mybatis/mappers/common/*.xml";

    /** Field description */
    static final String MAPPER_CONFIG = "classpath:mybatis/mybatis-config.xml";

    @Value("${network.datasource.url}")
    private String      url;
    @Value("${network.datasource.username}")
    private String      user;
    @Value("${network.datasource.password}")
    private String      password;
    @Value("${network.datasource.driverClassName}")
    private String      driverClass;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name = "dataTransactionManager")
    @Primary
    public DataSourceTransactionManager dataTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    @Bean(name = "dataSqlSessionFactory")
    @Primary
    public SqlSessionFactory dataSourceSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(MAPPER_CONFIG));
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));

        return sessionFactory.getObject();
    }
}