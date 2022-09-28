package se.salt.jfs.kanyeapi.controller;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public FilterRegistrationBean<LogIncomingTimeFilter> logFilter() {
        FilterRegistrationBean<LogIncomingTimeFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogIncomingTimeFilter());
        registrationBean.addUrlPatterns("/api/quotes");

        return registrationBean;
    }
}
