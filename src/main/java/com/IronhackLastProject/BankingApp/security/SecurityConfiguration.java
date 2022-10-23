package com.IronhackLastProject.BankingApp.security;

import com.IronhackLastProject.BankingApp.services.users.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }


    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/users").hasAnyRole( "HOLDER", "ADMIN")
                .mvcMatchers(HttpMethod.POST, "/accountHolder**").hasRole("HOLDER")
                .mvcMatchers(HttpMethod.POST, "/createSavings").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/createCreditCard").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/createChecking").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.GET, "/accounts").hasRole("HOLDER")
                .mvcMatchers(HttpMethod.PUT, "/changeStatus**").hasRole("HOLDER")
                .mvcMatchers(HttpMethod.PATCH, "/transfer**").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/deleteAccount**").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/admin**").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/thirdParty**").hasRole("THIRD")

                .anyRequest().permitAll();

        httpSecurity.csrf().disable();

        return httpSecurity.build();

    }
}

