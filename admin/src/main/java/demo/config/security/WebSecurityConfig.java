package demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    protected SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable) // 關閉basic明文驗證
                .csrf(AbstractHttpConfigurer::disable) // 關閉csrf，前後端分離架構不需要csrf保護
                .formLogin(AbstractHttpConfigurer::disable) // 關閉默認登入頁
                .logout(AbstractHttpConfigurer::disable) // 關閉默認登出頁
//                .exceptionHandling(exception -> ) // 設置異常的entry point
                .authorizeHttpRequests(
                        requests -> requests
                                // 允許所有OPTIONS請求
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                // 允許直接訪問登入API
                                .requestMatchers("/auth/login").permitAll()
                                .anyRequest().authenticated()
                )
        ;
        return http.build();
    }

}
