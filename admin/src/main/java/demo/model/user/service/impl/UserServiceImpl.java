package demo.model.user.service.impl;

import demo.biz.model.user.api.request.QueryUserReq;
import demo.biz.model.user.api.response.UserResp;
import demo.biz.model.user.converter.UserConverter;
import demo.biz.model.user.service.UserService;
import demo.biz.persistence.repository.UserRepository;
import demo.common.request.PageReq;
import demo.common.response.PageResp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
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
