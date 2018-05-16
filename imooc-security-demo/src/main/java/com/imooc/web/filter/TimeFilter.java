package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by wbcaoa on 2018/5/15.
 * javaweb规范过滤器
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timeFilter init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timeFilter doFilter start!");
        long startTime  = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("timeFilter doFilter 耗时::: " + ((new Date().getTime()) - startTime));
        System.out.println("timeFilter doFilter finsh!");
    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destroy!");
    }
}
