package ru.boronin.onlineshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.boronin.onlineshop.services.MyUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(myUserDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests().
                antMatchers("/admin").hasRole("ADMIN").
                antMatchers("/","/edit/**","/edit/*","/edit", "/images",
                        "/images/*", "/auth/login", "/new", "/new/*",
                        "/category/*", "/product/*", "/create", "/create/*",
                        "/addShoppingCart/*","/all","/error").permitAll().
                anyRequest().hasAnyRole("GUEST","ADMIN","CLIENT").
                and().
                formLogin().loginPage("/auth/login").
                loginProcessingUrl("/process_login").
                defaultSuccessUrl("/", true).
                failureUrl("/auth/login/?error").
                and().logout().logoutUrl("/logout").logoutSuccessUrl("/");


    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/css/**",
                "/js/**",
                "/fonts/**",
                "/images/**",
                "/static/**", "/static", "/images", "/static/images",
                "static/*", "static/images/*"
        );
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

}

//
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private MyUserDetailsService myUserDetailsService;
//
//    private final AuthProviderImpl authProvider;
//    @Autowired
//    public SecurityConfig(AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
//        authenticationManagerBuilder.authenticationProvider(authProvider);
//    }
//}