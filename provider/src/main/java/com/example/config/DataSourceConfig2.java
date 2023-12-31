package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.dao.second", sqlSessionTemplateRef = "blogSqlSessionTemplate2")
public class DataSourceConfig2 {

    @Value("${spring.datasource.db2.jdbcUrl}")
    private String url;

    @Value("${spring.datasource.db1.username}")
    private String name;

    @Value("${spring.datasource.db1.password}")
    private String password;

    @Bean(name = "blogDataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource blogDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(name);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(10);
        druidDataSource.setMinIdle(5);
        druidDataSource.setInitialSize(10);
        return druidDataSource;
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

    @Bean("blogSqlTransactionManager2")
    public DataSourceTransactionManager blogSqlTransactionManager(@Qualifier("blogDataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}