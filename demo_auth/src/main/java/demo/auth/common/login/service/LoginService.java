package demo.auth.common.login.service;

import demo.auth.common.login.bo.LoginUser;
import demo.auth.common.login.request.LoginReq;
import demo.auth.common.login.response.LoginResp;
import demo.auth.common.utils.JwtUtils;
import demo.auth.persistence.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;

    public LoginResp login(LoginReq loginRequest) {
        final String username = loginRequest.getUsername();
        final String password = loginRequest.getPassword();

        // 傳遞使用者密碼給SpringSecurity執行校驗，如果校驗失敗，會進入BadCredentialsException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        // 驗證通過，設定授權資訊至SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 如果驗證通過了，從傳回的authentication中獲得完整的UserDetails訊息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        // TODO 放進Redis
        RedisService.addUser(loginUser);

        // 將使用者的ID、名稱等資訊保存在jwt的token中
        String token = JwtUtils.generateToken(loginUser.getUsername());

        LoginResp loginResp = new LoginResp();
        loginResp.setUsername(username);
        loginResp.setToken(token);

        return loginResp;
    }

}
