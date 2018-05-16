package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;

/**
 * Created by wbcaoa on 2018/5/15.
 * 继承WebMvcConfigurerAdapter 配置拦截器
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 配置第三方过滤器
     */
    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();

        filterRegistrationBean.setFilter(timeFilter);
        ArrayList<String> urls = new ArrayList<String>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);//指定过滤urls
        return filterRegistrationBean;
    }

}
