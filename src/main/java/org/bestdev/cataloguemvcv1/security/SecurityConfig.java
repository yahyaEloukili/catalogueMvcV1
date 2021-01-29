package org.bestdev.cataloguemvcv1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //les regles de sécurité, spring security va afficher un formulaire par defaut
        http.formLogin();
        http.authorizeRequests().antMatchers("/index").hasRole("USER");
        http.authorizeRequests().antMatchers("/addProduct","/edit","/edit","/save","/delete").hasRole("ADMIN");
        http.exceptionHandling().accessDeniedPage("/403");
    }
}
