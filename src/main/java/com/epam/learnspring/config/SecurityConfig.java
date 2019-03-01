package com.epam.learnspring.config;

//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers("/head").access("hasRole('HEAD')")
//                .antMatchers("/employee").access("hasAnyRole('{HEAD, EMPLOYEE}')")
//                .antMatchers("/").permitAll()
//                .and().csrf().disable().formLogin().defaultSuccessUrl("/", false);
//    }
//}
