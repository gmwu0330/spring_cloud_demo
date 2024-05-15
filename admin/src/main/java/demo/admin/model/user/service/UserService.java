package demo.admin.model.user.service;


import demo.common.request.PageReq;
import demo.common.response.PageResp;
import demo.admin.model.user.api.request.QueryUserReq;
import demo.admin.model.user.api.response.UserResp;

import java.util.List;

public interface UserService {

    List<UserResp> queryList(QueryUserReq req);
    PageResp<UserResp> queryPage(PageReq<QueryUserReq> pageReq);
}
