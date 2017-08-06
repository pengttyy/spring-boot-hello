package com.pengttyy.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by pengt on 2017/8/6.
 */
@Configuration
@MapperScan(value = "com.pengttyy.mapper.bscap", sqlSessionTemplateRef = "bscapSqlSessionTemplate")
public class MybatisDataSourceConfig2 {

    @Bean("bscapDataSource")
    @ConfigurationProperties("spring.datasource.bscap")
    public DataSource bscapDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("bscapSqlSessionFactory")
    public SqlSessionFactory bscapSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(this.bscapDataSource());
        return bean.getObject();
    }

    @Bean("bscapTransactionManager")
    public DataSourceTransactionManager bscapTransactionManager() {
        return new DataSourceTransactionManager(this.bscapDataSource());
    }

    @Bean("bscapSqlSessionTemplate")
    public SqlSessionTemplate bscapSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(this.bscapSqlSessionFactory());
    }
}
