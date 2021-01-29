package org.bestdev.cataloguemvcv1.security;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
        //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select login as principal,pass as credentials,active from " +
          //      "user where login=?").authoritiesByUsernameQuery("select login as principal" +
            //    ",role as role from users_roles where login=?")
        //.passwordEncoder(new Md4PasswordEncoder())
        //.rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //les regles de sécurité, spring security va afficher un formulaire par defaut
        http.formLogin();
        //use my form 
        //http.formLogin();
        // http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
        http.authorizeRequests().antMatchers("/index").hasRole("USER");
        http.authorizeRequests().antMatchers("/addProduct","/edit","/edit","/save","/delete").hasRole("ADMIN");
        http.exceptionHandling().accessDeniedPage("/403");
    }
}
