package demo.auth.model.admin.user.service;


import demo.auth.model.admin.user.api.request.QueryUserReq;
import demo.auth.model.admin.user.api.response.UserResp;
import demo.common.request.PageReq;
import demo.common.response.PageResp;

import java.util.List;

public interface UserService {

    List<UserResp> queryList(QueryUserReq req);
    PageResp<UserResp> queryPage(PageReq<QueryUserReq> pageReq);
}
