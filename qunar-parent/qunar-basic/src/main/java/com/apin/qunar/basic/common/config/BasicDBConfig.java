package com.apin.qunar.basic.common.config;

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
 * @outhor lujian
 * @create 2018-06-25 7:27
 */
@Configuration
public class BasicDBConfig implements EnvironmentAware {

    private Environment environment;

    @Bean
    public SqlSessionFactory basicSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/apin/qunar/basic/dao/xml/*Mapper.xml"));
        sqlSessionFactoryBean.setDataSource(basicDataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer basicMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.apin.qunar.basic.dao.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("basicSqlSessionFactory");
        return mapperScannerConfigurer;
    }

    private DataSource basicDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(environment.getProperty("mysql.basicDB.username"));
        druidDataSource.setPassword(environment.getProperty("mysql.basicDB.password"));
        druidDataSource.setUrl(environment.getProperty("mysql.basicDB.url"));
        druidDataSource.setConnectionInitSqls(Lists.newArrayList("set names utf8"));
        return druidDataSource;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}