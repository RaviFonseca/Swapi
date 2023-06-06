//package com.example.Swapi.SpringSecurity;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
//import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
//import org.springframework.session.web.http.HttpSessionIdResolver;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//public class SessionConfig  extends AbstractHttpSessionApplicationInitializer {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public HttpSessionIdResolver httpSessionIdResolver(){
//        return HeaderHttpSessionIdResolver.xAuthToken();
//    }
//}
