package com.ccljjk.server.config.auth;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // 配置拦截规则
        http.authorizeRequests().antMatchers("/").permitAll()
                 .antMatchers("/page1/**").hasRole("LEVEL1")
                 .antMatchers("/page2/**").hasRole("LEVEL2")
                 .antMatchers("/page3/**").hasRole("LEVEL3")
                 .antMatchers("/hello").hasRole("LEVEL3");
        // 配置登录功能
        // 异步登录不再需要后台配置登录页面地址，只需要配置登录参数和api地址即可
        http.formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }
    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public UserDetailServiceImpl userDetailService (){
        return new UserDetailServiceImpl () ;
    }
    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
