package com.pengttyy.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by pengt on 2017/8/6.
 */
@Configuration
@MapperScan(value = "com.pengttyy.mapper.bs", sqlSessionTemplateRef = "bsSqlSessionTemplate")
public class MybatisDataSourceConfig {

    @Primary
    @Bean("bsDataSource")
    @ConfigurationProperties("spring.datasource.bs")
    public DataSource bsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("bsSqlSessionFactory")
    public SqlSessionFactory bsSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(this.bsDataSource());
        return bean.getObject();
    }

    @Primary
    @Bean("bsTransactionManager")
    public DataSourceTransactionManager bsTransactionManager() {
        return new DataSourceTransactionManager(this.bsDataSource());
    }

    @Primary
    @Bean("bsSqlSessionTemplate")
    public SqlSessionTemplate bsSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(this.bsSqlSessionFactory());
    }
}
