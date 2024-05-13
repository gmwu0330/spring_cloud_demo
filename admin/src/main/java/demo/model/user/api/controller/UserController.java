package demo.model.user.api.controller;

import demo.biz.model.user.api.request.QueryUserReq;
import demo.biz.model.user.api.response.UserResp;
import demo.biz.model.user.service.UserService;
import demo.common.request.PageReq;
import demo.common.response.BaseResponse;
import demo.common.response.PageResp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/demo/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/query/list")
    public BaseResponse<List<UserResp>> queryList(@RequestBody QueryUserReq req){
        return BaseResponse.successWithData(userService.queryList(req));
    }

    @PostMapping("/query/page")
    public BaseResponse<PageResp<UserResp>> queryPage(@RequestBody PageReq<QueryUserReq> pageReq) {
        return BaseResponse.successWithData(userService.queryPage(pageReq));
    }

}
