package demo.auth.service;

import demo.auth.request.LoginReq;
import demo.auth.response.LoginResp;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;

    public LoginResp login(LoginReq loginRequest){
        return new LoginResp();
    }

}
