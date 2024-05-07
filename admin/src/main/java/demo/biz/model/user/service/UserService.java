package demo.biz.model.user.service;

import demo.biz.model.user.api.request.QueryUserReq;
import demo.biz.model.user.api.response.UserResp;
import demo.common.request.PageReq;
import demo.common.response.PageResp;

import java.util.List;

public interface UserService {

    List<UserResp> queryList(QueryUserReq req);
    PageResp<UserResp> queryPage(PageReq<QueryUserReq> pageReq);
}
