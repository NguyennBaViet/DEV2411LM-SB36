package com.devmaster.Lesson10.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz ->
                authz.requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/login","/registry","/logout").permitAll()
                        .anyRequest().permitAll())
                .formLogin(form ->form.loginPage("/login")
                        .defaultSuccessUrl("/admin",true)
                        .failureUrl("/login?error")
                        .failureHandler(authenticationFailureHandler())
                        .permitAll()
                )
                .logout(logout ->logout.logoutUrl("/logout") //url để kích hoạt đăng xuất
                        .logoutSuccessUrl("/login?logout")  //Sau khi đăng xuất thành công
                        .permitAll());
        return http.build();
    }
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler(){
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException{
                String errsMessage = "Sai tên đăng nhập hoặc mật khẩu";
                if(exception instanceof UsernameNotFoundException){
                    errsMessage = exception.getMessage();
                }
                request.setAttribute("LoginError", errsMessage);
                getRedirectStrategy().sendRedirect(request, response, "/login?error");
            }
        };
    }
}
