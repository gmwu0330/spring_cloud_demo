package demo.admin.auth.controller;

import demo.admin.auth.request.LoginReq;
import demo.admin.auth.service.AuthService;
import demo.admin.auth.response.LoginResp;
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

    @PostMapping("/test")
    public BaseResponse<Void> test() {
        authService.test();
        return BaseResponse.success();
    }

}
