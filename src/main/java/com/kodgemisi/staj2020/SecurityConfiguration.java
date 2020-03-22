package com.kodgemisi.staj2020;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@AllArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http
                .authorizeRequests()
                .antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**", "/app/**", "/h2_console/**","/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/hr/login")
                .failureUrl("/hr/login?loginFailed=true")//hata nesajı gösterilebilir, bu bilgiyle.
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .rememberMe().userDetailsService(userDetailsService);
    }
}
