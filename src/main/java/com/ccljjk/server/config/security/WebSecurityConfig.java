package com.ccljjk.server.config.security;

import com.ccljjk.server.handler.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity // 启用Spring Security的Web安全支持
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true) //开启方法权限注解支持
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${resource.server.permitUrl}")
    private String permitUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /* 开启跨域共享，  跨域伪造请求限制=无效 */
        http.cors().and().csrf().disable();

        /* 开启授权认证 */
        http.authorizeRequests()
                .antMatchers(permitUrl.split(",")).permitAll()   // 放行的URL
                .anyRequest().authenticated();

        /* 登录配置 */
        http.formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");

        /* 登录失败后的处理 */
        http.formLogin().failureHandler(new LoginFailureHandler());

        /* 登录过期/未登录 处理 */
        http.exceptionHandling().authenticationEntryPoint(new LoginExpireHandler());

        /* 权限不足(没有赋予角色) 处理 */
        http.exceptionHandling().accessDeniedHandler(new AuthLimitHandler());

        /* 登录成功后的处理 */
        http.formLogin().successHandler(new LoginSuccessHandler());

        /* 退出成功处理器 */
        http.logout().logoutUrl("/logout").permitAll()
                .invalidateHttpSession(true)
                .logoutSuccessHandler(new LogoutHandler());
    }

    @Bean
    public UserDetailServiceImpl userDetailService() {
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}