package demo.auth.common.login.controller;

import demo.auth.common.login.response.LoginResp;
import demo.auth.common.login.service.LoginService;
import demo.auth.common.login.request.LoginReq;
import demo.common.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginService authService;

    @PostMapping("/login")
    public BaseResponse<LoginResp> login(@RequestBody @Valid LoginReq req) {
        return BaseResponse.successWithData(authService.login(req));
    }

}
