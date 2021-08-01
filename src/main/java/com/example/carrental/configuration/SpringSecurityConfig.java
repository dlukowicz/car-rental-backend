package com.example.carrental.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin1pass").roles("USER", "ADMIN").and()
                .withUser("user1").password("user1pass").roles("USER").and()
                .withUser("user2").password("user2pass").roles("USER").and()
                .withUser("user3").password("user3pass").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().
                disable()
                .authorizeRequests()
                //.antMatchers( "/**")
                .antMatchers("/availablecars","/reservations")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        http.cors();
    }
}
