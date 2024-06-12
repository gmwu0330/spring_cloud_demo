package demo.auth.model.user.service.impl;


import demo.auth.model.user.service.UserService;
import demo.common.request.PageReq;
import demo.common.response.PageResp;
import demo.auth.model.user.api.request.QueryUserReq;
import demo.auth.model.user.api.response.UserResp;
import demo.auth.model.user.converter.UserConverter;
import demo.auth.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final AuthUserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public List<UserResp> queryList(QueryUserReq req) {
        return userRepository.findAll().stream().map(userConverter::toResp).toList();
    }

    @Override
    public PageResp<UserResp> queryPage(PageReq<QueryUserReq> pageReq) {
        return null;
    }
}
