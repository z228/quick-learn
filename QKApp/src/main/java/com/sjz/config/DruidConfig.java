package com.sjz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
    /**
     * 配置监控服务器
     * @return 返回监控注册的servlet对象
     * @author SimpleWu
     */
// 后台监控
//因为springboot内置了servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        //方法一：setInitParameters(Map<String, String> initParameters)
        // 后台需要有人登录，账号密码配置
        HashMap<String, String> initParameter = new HashMap<>();
        //添加配置
        initParameter.put("loginUsername","admin"); //登录key是固定的，loginUsername
        initParameter.put("loginPassword","123456");
        //允许谁可以访问
        initParameter.put("allow","");// 如果为空 ，则全部都可以访问；也可以localhost，只允许本机访问；
        bean.setInitParameters(initParameter);   // 设置初始化参数

        //方法二；addInitParameter(String name, String value)
        // 添加IP白名单(允许谁可以访问)
//    bean.addInitParameter("allow", "127.0.0.1");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        //bean.addInitParameter("deny", "127.0.0.1");
        // 是否能够重置数据
//    bean.addInitParameter("resetEnable", "false");

        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());

        HashMap<String , String> initParameters = new HashMap<>();
        // 这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
