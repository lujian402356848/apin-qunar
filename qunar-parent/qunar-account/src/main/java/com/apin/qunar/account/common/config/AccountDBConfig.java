package com.apin.qunar.account.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @outhor Wubo
 * @create 2018-09-5 17:27
 */
@Configuration
public class AccountDBConfig implements EnvironmentAware {

    private Environment environment;

    @Bean
    public SqlSessionFactory accountSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/apin/qunar/account/dao/xml/*Mapper.xml"));
        sqlSessionFactoryBean.setDataSource(accountDataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer accountMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.apin.qunar.account.dao.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("accountSqlSessionFactory");
        return mapperScannerConfigurer;
    }

    private DataSource accountDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(environment.getProperty("mysql.accountDB.username"));
        druidDataSource.setPassword(environment.getProperty("mysql.accountDB.password"));
        druidDataSource.setUrl(environment.getProperty("mysql.accountDB.url"));
        druidDataSource.setConnectionInitSqls(Lists.newArrayList("set names utf8"));
        return druidDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(accountDataSource());
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}