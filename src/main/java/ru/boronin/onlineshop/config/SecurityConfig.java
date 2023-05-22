package ru.boronin.onlineshop.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.boronin.onlineshop.services.MyUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private MyUserDetailsService myUserDetailsService;
@Autowired
public SecurityConfig(MyUserDetailsService myUserDetailsService){
    this.myUserDetailsService=myUserDetailsService;
}

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().
                antMatchers("/","/images","/images/*","/auth/login","/new","/new/*",
                        "/category/*","/product/*","/addShoppingCart/*","/all").permitAll().
                anyRequest().authenticated().
                and().
                formLogin().loginPage("/auth/login").
                loginProcessingUrl("/process_login").
                defaultSuccessUrl("/login_ok", true).
                failureUrl("/auth/login");


    }
@Bean
    public PasswordEncoder getPasswordEncoder(){
    return NoOpPasswordEncoder.getInstance();
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