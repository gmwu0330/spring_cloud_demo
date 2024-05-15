package demo.admin.config;

import demo.admin.common.filter.AuthorizationCheckFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 執行身份驗證的關鍵組件
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * 管理身份驗證的組件
     */
    @Autowired
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) throws Exception {
        return new ProviderManager(authenticationProvider);
    }

    /**
     * 以便將用戶密碼進行安全的雜湊存儲
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable) // 關閉basic明文驗證
                .csrf(AbstractHttpConfigurer::disable) // 關閉csrf，前後端分離架構不需要csrf保護
                .formLogin(AbstractHttpConfigurer::disable) // 關閉默認登入頁
                .logout(AbstractHttpConfigurer::disable) // 關閉默認登出頁
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// 關閉session
//                .exceptionHandling(exception -> ) // 設置異常的entry point
                .authorizeHttpRequests(
                        requests -> requests
                                // 允許所有OPTIONS請求
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                // 允許直接訪問登入API
                                .requestMatchers("/auth/login").permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(new AuthorizationCheckFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }

}
