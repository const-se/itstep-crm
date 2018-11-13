package org.itstep.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, 1 AS enabled FROM users WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, role AS authority FROM users WHERE username = ?")
            .passwordEncoder(new PasswordEncoder() {
                @Override
                public String encode(CharSequence charSequence) {
                    return charSequence.toString();
                }

                @Override
                public boolean matches(CharSequence charSequence, String s) {
                    return s.contentEquals(charSequence);
                }
            });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login", "/logout").permitAll()
                .anyRequest().access("hasRole('ROLE_USER')")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout")
                .and()
            .csrf().disable();
    }
}
