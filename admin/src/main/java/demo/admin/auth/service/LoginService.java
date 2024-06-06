package demo.admin.auth.service;

import demo.admin.auth.bo.LoginUser;
import demo.admin.auth.request.LoginReq;
import demo.admin.auth.response.LoginResp;
import demo.admin.common.utils.JwtUtils;
import demo.admin.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final AuthUserRepository authUserRepository;
    private final AuthenticationManager authenticationManager;

    public LoginResp login(LoginReq loginRequest) {
        final String username = loginRequest.getUsername();
        final String password = loginRequest.getPassword();

        // 傳遞使用者密碼給SpringSecurity執行校驗，如果校驗失敗，會進入BadCredentialsException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        // 驗證通過，設定授權資訊至SecurityContextHolder
        // TODO 放進Redis
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 如果驗證通過了，從傳回的authentication中獲得完整的UserDetails訊息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        // 將使用者的ID、名稱等資訊保存在jwt的token中
        String token = JwtUtils.generateToken(loginUser);

        LoginResp loginResp = new LoginResp();
        loginResp.setUsername(username);
        loginResp.setToken(token);

        return loginResp;
    }

    public void test() {
        authUserRepository.findByUsername("admin").ifPresent(user -> {
//            user.setPassword(passwordEncoder.encode("admin123"));
//            authUserRepository.save(user);
        });
    }

}
