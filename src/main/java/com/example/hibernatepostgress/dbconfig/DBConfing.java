package com.example.hibernatepostgress.dbconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DBConfing {
    @Value("${spring.datasource.driver.class.name}")
    private String driverclass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;



    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url,userName,password);
        driverManagerDataSource.setDriverClassName(driverclass);
        return  driverManagerDataSource;
    }

    /*
    Without (name="entityManagerFactory") this there is error Consider defining a bean named 'entityManagerFactory' in your configuration.
    * JPA by default search sessionFactory by name 'entityManagerFactory' so change my code as:*/
    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());
        localSessionFactoryBean.setHibernateProperties(getProperties());
        localSessionFactoryBean.setPackagesToScan(new String[]{"com.example.hibernatepostgress.model"});
        return localSessionFactoryBean;
    }
    private Properties getProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",dialect);
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");
        return  properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory factory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factory);
        return transactionManager;
    }
}
