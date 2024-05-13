package demo.auth.controller;

import demo.auth.request.LoginReq;
import demo.auth.response.LoginResp;
import demo.auth.service.AuthService;
import demo.common.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public BaseResponse<LoginResp> login(@RequestBody @Valid LoginReq req) {
        return BaseResponse.successWithData(authService.login(req));
    }

}
