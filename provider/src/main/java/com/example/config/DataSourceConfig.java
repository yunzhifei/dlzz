package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.dao.dao", sqlSessionTemplateRef = "blogSqlSessionTemplate")
public class DataSourceConfig {

    @Primary
    @Bean(name = "blogDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource blogDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "blogSqlSessionFactory")
    public SqlSessionFactory blogSqlSessionFactory(@Qualifier("blogDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "blogSqlSessionTemplate")
    public SqlSessionTemplate blogSqlSessionTemplate(@Qualifier("blogSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("blogSqlTransactionManager")
    public DataSourceTransactionManager blogSqlTransactionManager(@Qualifier("blogDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}