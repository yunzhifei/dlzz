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

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.dao.second", sqlSessionTemplateRef = "blogSqlSessionTemplate2")
public class DataSourceConfig2 {

    @Bean(name = "blogDataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource blogDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "blogSqlSessionFactory2")
    public SqlSessionFactory blogSqlSessionFactory(@Qualifier("blogDataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:second/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "blogSqlSessionTemplate2")
    public SqlSessionTemplate blogSqlSessionTemplate(@Qualifier("blogSqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}