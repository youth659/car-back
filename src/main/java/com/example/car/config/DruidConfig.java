package com.example.car.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置
 * <br>
 * created date 2021/4/23 15:36
 *
 * @author yh
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控
    @Bean
    public ServletRegistrationBean StatViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        // 配置后台账号密码
        Map<String, String> initParameters = new HashMap<>();
        // 增加配置， 登录key 固定key
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        // 允许谁可以访问
        initParameters.put("allow", "");
        bean.setInitParameters(initParameters);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStarFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());
        // 可以过滤那些请求呢
        Map<String, String> initParameters = new HashMap<>();
        // 这些东西不进行统计
        initParameters.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
