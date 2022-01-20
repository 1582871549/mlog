package com.meng.mlog.common.config;

import com.meng.mlog.common.filter.ExceptionFilter;
import com.meng.mlog.common.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter> exceptionFilterRegistrationBean(ExceptionFilter exceptionFilter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(exceptionFilter);
        registration.addUrlPatterns("/*");
        // 需要保证异常转发过滤器在所有过滤器之前
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<Filter> loginFilterRegistrationBean(LoginFilter loginFilter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(loginFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public ExceptionFilter exceptionFilter() {
        return new ExceptionFilter();
    }

    @Bean
    public LoginFilter loginFilter() {
        return new LoginFilter();
    }

}
