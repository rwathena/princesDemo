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
 * @ Date：      Created in 3:39 PM 12/13/2018
 * @ Description:
 * @ Version:     1.0
 */
@Configuration
@MapperScan(basePackages = {"com.rwathena.prince.serviceImpl.dao.userCenter"},
        sqlSessionFactoryRef = "dataUserSqlSessionFactory")
public class UserCenterDataConfig {
    /** Field description */
    static final String MAPPER_LOCATION = "classpath:mybatis/mappers/user/*.xml";

    /** Field description */
    static final String MAPPER_CONFIG = "classpath:mybatis/mybatis-config.xml";

    @Value("${usercenter.datasource.url}")
    private String      url;
    @Value("${usercenter.datasource.username}")
    private String      user;
    @Value("${usercenter.datasource.password}")
    private String      password;
    @Value("${usercenter.datasource.driverClassName}")
    private String      driverClass;

    @Bean(name = "userCenterDataSource")
    public DataSource userCenterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name = "userCenterDataSqlSessionFactory")
    public DataSourceTransactionManager userCenterDataSqlSessionFactory() {
        return new DataSourceTransactionManager(userCenterDataSource());
    }
    @Bean(name = "dataUserSqlSessionFactory")
    public SqlSessionFactory dataUserSqlSessionFactory(@Qualifier("userCenterDataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(MAPPER_CONFIG));
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));

        return sessionFactory.getObject();
    }
}